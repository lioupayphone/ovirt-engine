package org.ovirt.engine.ui.webadmin.section.main.presenter.tab.virtualMachine;

import org.ovirt.engine.core.common.businessentities.GuestContainer;
import org.ovirt.engine.core.common.businessentities.VM;
import org.ovirt.engine.ui.common.presenter.AbstractSubTabPresenter;
import org.ovirt.engine.ui.common.uicommon.model.SearchableDetailModelProvider;
import org.ovirt.engine.ui.common.widget.tab.ModelBoundTabData;
import org.ovirt.engine.ui.uicommonweb.models.vms.VmGuestContainerListModel;
import org.ovirt.engine.ui.uicommonweb.models.vms.VmListModel;
import org.ovirt.engine.ui.uicommonweb.place.WebAdminApplicationPlaces;
import org.ovirt.engine.ui.webadmin.ApplicationConstants;
import org.ovirt.engine.ui.webadmin.gin.AssetProvider;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlace;

public class SubTabVirtualMachineGuestContainerPresenter
        extends AbstractSubTabVirtualMachinePresenter<VmGuestContainerListModel, SubTabVirtualMachineGuestContainerPresenter.ViewDef,
        SubTabVirtualMachineGuestContainerPresenter.ProxyDef> {

    private static final ApplicationConstants constants = AssetProvider.getConstants();

    @ProxyCodeSplit
    @NameToken(WebAdminApplicationPlaces.virtualMachineContainerSubTabPlace)
    public interface ProxyDef extends TabContentProxyPlace<SubTabVirtualMachineGuestContainerPresenter> {
    }

    public interface ViewDef extends AbstractSubTabPresenter.ViewDef<VM> {
    }

    @TabInfo(container = VirtualMachineSubTabPanelPresenter.class)
    static TabData getTabData(
            SearchableDetailModelProvider<GuestContainer, VmListModel<Void>, VmGuestContainerListModel> modelProvider) {
        return new ModelBoundTabData(constants.virtualMachineContainerSubTabLabel(), 4, modelProvider);
    }

    @Inject
    public SubTabVirtualMachineGuestContainerPresenter(EventBus eventBus, ViewDef view, ProxyDef proxy,
            PlaceManager placeManager, SearchableDetailModelProvider<GuestContainer, VmListModel<Void>,
            VmGuestContainerListModel> modelProvider, VirtualMachineMainTabSelectedItems selectedItems) {
        super(eventBus, view, proxy, placeManager, modelProvider, selectedItems,
                VirtualMachineSubTabPanelPresenter.TYPE_SetTabContent);
    }
}
