/**
 * Created by pouncilt on 10/21/14.
 */
(function(angular) {
    "use strict";

    angular.module('EscreeningDashboardApp.services.assessmentVariable').directive('mheAssessmentVarTblDir', [function() {

        return {
            restrict: 'EA',
            scope: {
                assessmentVariable: '=',
                guid: '=',
                surveyId: '@',
                data: '=assessmentVariables'
            },
            controller: ['$scope', '$rootScope', '$filter', 'ngTableParams', 'AssessmentVariableService', function ($scope, $rootScope, $filter, ngTableParams, AssessmentVariableService) {
                $scope.assessmentVariableTypes = ['Question', 'Answer', 'Custom', 'Formula'];

                $scope.selectAssessmentVariable = function(someAssessmentVariable) {
                    // Adding this here because the code above doesn'ter trigger a change on $scope.$watch
	                $scope.assessmentVariable = someAssessmentVariable;

                    $scope.$emit('closeAssessmentVariableMenuRequested', {guid: $scope.guid, selectedAssessmentVariable: $scope.assessmentVariable});
                };

                $scope.searchObj = {
                    type: ''
                };

                $scope.$watch("searchObj.type", function (currentlySelectedKind, previouslySelectedKind) {
                    if(currentlySelectedKind === previouslySelectedKind){

                    } else {
                        if(!Object.isDefined(currentlySelectedKind)) {
                            $scope.searchObj.type = "";
                            $scope.assessmentVariableTable.reload();
                        }
                    }

                }, true);

                var setTable = function () {
                    $scope.assessmentVariableTable = new ngTableParams({
                        page: 1, // show first page
                        count: 10, // count per page
                        filter: $scope.searchObj
                    }, {
                        counts: [],
                        total: 0,
                        getData: function ($defer, params) {
                            if(Object.isDefined($scope.data)) {
                                $scope.data.then(function (assessmentVariables) {
                                    params.total(assessmentVariables.length);
                                    var data = params.filter() ? $filter('filter')(assessmentVariables, params.filter()) : assessmentVariables;
                                    params.total(data.length); // set total for recalc pagination
                                    $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                                });
                            } else if(Object.isNumber($scope.surveyId)){
                                AssessmentVariableService.query({surveyId: $scope.surveyId}).then(function(data) {
                                    // use build-in angular filter
                                    //params.total(data.length);
                                    data = params.filter() ? $filter('filter')(data, params.filter()) : data;
                                    params.total(data.length); // set total for recalc pagination
                                    $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                                });
                            }

                        }
                    });
                };

                setTable();
            }],
            templateUrl: 'resources/editors/js/app/directives/assessmentVariableTable/assessmentVariableTable.html',
            link: function(scope, element, attributes, controller) {
                element.addClass("assessmentVariableTable");
            }
        };

    }]);
})(angular);
