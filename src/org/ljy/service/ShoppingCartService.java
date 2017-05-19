package org.ljy.service;

import org.ljy.common.PagedResult;
import org.ljy.domain.ShoppingCart;
import org.ljy.domain.ShoppingCartExample;

public interface ShoppingCartService {
    long countByExample(ShoppingCartExample example);

    boolean addToCart(ShoppingCart shoppingCart);

    boolean removeFromCart(Long cartId);

    PagedResult queryShoppingCartByPage(Long userId,Integer pageNo,Integer pageSize);
}
