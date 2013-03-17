package org.ovirt.engine.core.dao;

import java.util.List;

import org.ovirt.engine.core.common.businessentities.ActionGroup;
import org.ovirt.engine.core.common.businessentities.StorageDomain;
import org.ovirt.engine.core.compat.Guid;
import org.ovirt.engine.core.compat.NGuid;

/**
 * <code>StorageDomainDAO</code> defines a type for performing CRUD operations on instances of {@link StorageDomain}.
 *
 *
 */
public interface StorageDomainDAO extends DAO, SearchDAO<StorageDomain>, AutoRecoverDAO<StorageDomain> {
    /**
     * Retrieves the master storage domain for the specified pool.
     *
     * @param pool
     *            the storage pool
     * @return the master storage domain
     */
    Guid getMasterStorageDomainIdForPool(Guid pool);

    /**
     * Retrieves the master storage domain for the specified pool.
     *
     * @param pool
     *            the storage pool
     * @return the master storage domain
     */
    Guid getIsoStorageDomainIdForPool(Guid pool);

    /**
     * Retrieves the storage domain with specified id.
     *
     * @param id
     *            the storage domain id
     * @return the storage domain
     */
    StorageDomain get(Guid id);

    /**
     * Retrieves the storage domain with specified id, with optional permissions filtering.
     *
     * @param id
     *            the storage domain id
     * @param userID
     *            the ID of the user requesting the information
     * @param isFiltered
     *            Whether the results should be filtered according to the user's permissions
     * @return the storage domain
     */
    StorageDomain get(Guid id, Guid userID, boolean isFiltered);

    /**
     * Retrieves the storage domain for the given pool with the specified id.
     *
     * @param id
     *            the storage domain id
     * @param storagepool
     *            the storage pool
     * @return the storage domain
     */
    StorageDomain getForStoragePool(Guid id, NGuid storagepool);

    /**
     * Retrieves all storage domains for the specified connection.
     *
     * @param connection
     *            The connection
     * @return the list of storage domains (empty if no storage is using this connection)
     */
    List<StorageDomain> getAllForConnection(String connection);

    /**
     * Retrieves all storage domains for the specified connection id.
     *
     * @param connectionId
     *            The connection id
     * @return the list of storage domains (empty if no storage is using this connection id)
     */
    List<StorageDomain> getAllByConnectionId(Guid connectionId);

    /**
     * Retrieves all storage domains for the specified storage pool.
     *
     * @param pool
     *            the storage pool
     * @return the list of storage domains
     */
    List<StorageDomain> getAllForStoragePool(Guid pool);

    /**
     * Retrieves all storage domains for the specified storage pool, with optional filtering.
     *
     * @param pool
     *            the storage pool
     * @param userID
     *            the ID of the user requesting the information
     * @param isFiltered
     *            Whether the results should be filtered according to the user's permissions
     * @return the list of storage domains
     */
    List<StorageDomain> getAllForStoragePool(Guid pool, Guid userID, boolean isFiltered);

    /**
     * Retrieves all storage domains for the specified storage domain id.
     *
     * @param id
     *            the storage domain id
     * @return the list of storage domains
     */
    List<StorageDomain> getAllForStorageDomain(Guid id);

    /**
     * Retrieves all storage domains.
     *
     * @return the list of storage domains
     */
    List<StorageDomain> getAll();

    /**
     * Retrieves all storage domains with optional permission filtering.
     *
     * @param userID
     *            the ID of the user requesting the information
     * @param isFiltered
     *            Whether the results should be filtered according to the user's permissions
     *
     * @return the list of storage domains
     */
    List<StorageDomain> getAll(Guid userID, boolean isFiltered);

    /**
     * Retrieves all domain which contains image id
     *
     * @param imageId
     * @return List of storage domains.
     */
    List<StorageDomain> getAllStorageDomainsByImageId(Guid imageId);

    /**
     * Removes the specified storage domain.
     *
     * @param id
     *            the storage domain
     */
    void remove(Guid id);

    /**
     * Retrieves all storage domains for the specified connection.
     * @param storagePoolId
     *            The storage pool id
     * @param connection
     *            The connection
     * @return the list of storage domains (empty if no storage is using this connection)
     */
    List<StorageDomain> getAllByStoragePoolAndConnection(Guid storagePoolId, String connection);

    /**
     * Retrieves all storage domains of a given storage pool having a user permissions for a specific action.
     *
     * @param userId
     *            The user ID
     * @param actionGroup
     *            The action group ID
     * @param storagePoolId
     *            The storage pool ID
     * @return the list of storage domains (empty if no storage matches the criteria)
     */
    List<StorageDomain> getPermittedStorageDomainsByStoragePool(Guid userId, ActionGroup actionGroup, Guid storagePoolId);
}
