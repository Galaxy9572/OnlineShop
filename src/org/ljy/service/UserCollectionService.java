package org.ljy.service;

import org.ljy.domain.UserCollection;
import org.ljy.domain.UserCollectionExample;

/**
 * Created by ljy56 on 2017/4/19.
 */
public interface UserCollectionService {
    long countByExample(UserCollectionExample example);

    boolean collect(UserCollection userCollection);

    boolean removeCollection(Long collectionId);
}
