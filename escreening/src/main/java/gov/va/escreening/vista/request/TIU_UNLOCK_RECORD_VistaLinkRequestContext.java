package gov.va.escreening.vista.request;

import gov.va.med.vistalink.adapter.cci.VistaLinkConnection;
import gov.va.med.vistalink.rpc.RpcRequest;

/**
 * Created by pouncilt on 4/16/14.
 */
public class TIU_UNLOCK_RECORD_VistaLinkRequestContext<T extends VistaLinkRequestParameters> extends VistaLinkRequestBaseContext<T> {
    public TIU_UNLOCK_RECORD_VistaLinkRequestContext(RpcRequest request, VistaLinkConnection connection, T requestParameters) {
        super(request, connection, requestParameters);
    }
}
