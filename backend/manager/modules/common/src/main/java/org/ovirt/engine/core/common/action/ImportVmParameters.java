package org.ovirt.engine.core.common.action;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.ovirt.engine.core.common.businessentities.VM;
import org.ovirt.engine.core.common.businessentities.network.ExternalVnicProfileMapping;
import org.ovirt.engine.core.common.businessentities.storage.Disk;
import org.ovirt.engine.core.compat.Guid;

public class ImportVmParameters extends VmOperationParameterBase implements Serializable, ImportParameters {
    private static final long serialVersionUID = -6514416097090370831L;

    @Valid
    private VM vm;
    private Guid sourceDomainId;
    private Guid destDomainId;
    private Guid clusterId;
    private Map<Guid, Disk> diskMap;

    private Guid storagePoolId;
    private Map<Guid, Guid> imageToDestinationDomainMap;
    private boolean imagesExistOnTargetStorageDomain;
    private Guid cpuProfileId;
    private boolean copyCollapse;
    private boolean forceOverride;
    private boolean allowPartialImport;
    private Guid containerId;
    private Guid storageDomainId;
    private boolean importAsNewEntity;
    private Collection<ExternalVnicProfileMapping> externalVnicProfileMappings;
    private boolean reassignBadMacs;

    public ImportVmParameters() {
        this(Collections.<ExternalVnicProfileMapping>emptyList(), false);
    }

    public ImportVmParameters(
            Collection<ExternalVnicProfileMapping> externalVnicProfileMappings,
            boolean reassignBadMacs) {
        this.sourceDomainId = Guid.Empty;
        this.destDomainId = Guid.Empty;
        this.externalVnicProfileMappings = Objects.requireNonNull(externalVnicProfileMappings);
        this.reassignBadMacs = reassignBadMacs;
    }

    public ImportVmParameters(VM vm, Guid destStorageDomainId, Guid storagePoolId, Guid clusterId) {
        this(vm, Guid.Empty, destStorageDomainId, storagePoolId, clusterId);
    }

    public ImportVmParameters(VM vm, Guid sourceStorageDomainId, Guid destStorageDomainId, Guid storagePoolId,
            Guid clusterId) {
        super(vm.getId());
        containerId = vm.getId();
        sourceDomainId = sourceStorageDomainId;
        destDomainId = destStorageDomainId;
        setVm(vm);
        setStorageDomainId(destStorageDomainId);
        this.setStoragePoolId(storagePoolId);
        setClusterId(clusterId);
    }

    public VM getVm() {
        return vm;
    }

    public void setVm(VM vm) {
        this.vm = vm;
    }

    public Guid getSourceDomainId() {
        return sourceDomainId;
    }

    public Guid getDestDomainId() {
        return destDomainId;
    }

    @Override
    public Guid getClusterId() {
        return clusterId;
    }

    public void setClusterId(Guid clusterId) {
        this.clusterId = clusterId;
    }

    public void setDestDomainId(Guid destDomainId) {
        this.destDomainId = destDomainId;
    }

    public void setSourceDomainId(Guid sourceDomainId) {
        this.sourceDomainId = sourceDomainId;
    }

    public Map<Guid, Disk> getDiskMap() {
        return diskMap;
    }

    public void setDiskMap(Map<Guid, Disk> diskMap) {
        this.diskMap = diskMap;
    }

    public Guid getStoragePoolId() {
        return storagePoolId;
    }

    public void setStoragePoolId(Guid storagePoolId) {
        this.storagePoolId = storagePoolId;
    }

    public Guid getStorageDomainId() {
        return storageDomainId;
    }

    public void setStorageDomainId(Guid storageDomainId) {
        this.storageDomainId = storageDomainId;
    }

    public Map<Guid, Guid> getImageToDestinationDomainMap() {
        return imageToDestinationDomainMap;
    }

    public void setImageToDestinationDomainMap(Map<Guid, Guid> imageToDestinationDomainMap) {
        this.imageToDestinationDomainMap = imageToDestinationDomainMap;
    }

    public boolean isImagesExistOnTargetStorageDomain() {
        return imagesExistOnTargetStorageDomain;
    }

    public void setImagesExistOnTargetStorageDomain(boolean imagesExistOnTargetStorageDomain) {
        this.imagesExistOnTargetStorageDomain = imagesExistOnTargetStorageDomain;
    }

    public Guid getCpuProfileId() {
        return cpuProfileId;
    }

    public void setCpuProfileId(Guid cpuProfileId) {
        this.cpuProfileId = cpuProfileId;
    }

    public boolean getCopyCollapse() {
        return copyCollapse;
    }

    public void setCopyCollapse(boolean copyCollapse) {
        this.copyCollapse = copyCollapse;
    }

    public boolean getForceOverride() {
        return forceOverride;
    }

    public void setForceOverride(boolean forceOverride) {
        this.forceOverride = forceOverride;
    }

    public boolean isAllowPartialImport() {
        return allowPartialImport;
    }

    public void setAllowPartialImport(boolean allowPartialImport) {
        this.allowPartialImport = allowPartialImport;
    }

    public Guid getContainerId() {
        return containerId;
    }

    public void setContainerId(Guid containerId) {
        this.containerId = containerId;
    }

    public boolean isImportAsNewEntity() {
        return importAsNewEntity;
    }

    public void setImportAsNewEntity(boolean importAsNewEntity) {
        this.importAsNewEntity = importAsNewEntity;
    }

    public Collection<ExternalVnicProfileMapping> getExternalVnicProfileMappings() {
        return externalVnicProfileMappings;
    }

    public boolean isReassignBadMacs() {
        return reassignBadMacs;
    }
}
