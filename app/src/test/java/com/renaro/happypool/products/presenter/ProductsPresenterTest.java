package com.renaro.happypool.products.presenter;

import com.renaro.happypool.products.model.Product;
import com.renaro.happypool.products.model.ProductBO;
import com.renaro.happypool.products.view.ProductsListView;
import com.renaro.happypool.task.TaskExecutor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by renarosantos1 on 30/01/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductsPresenterTest {

    private ProductsListPresenter mPresenter;
    @Mock
    private ProductsListView mView;
    @Mock
    private ProductBO mProductBO;
    @Mock
    private TaskExecutor mTaskExecutor;
    @Mock
    private Product product;
    @Before
    public void setUp() throws Exception {
        mPresenter = new ProductsListPresenter(mView, mProductBO, mTaskExecutor);
    }

    @Test
    public void testIfEmptyStateIsCalledForEmptyList(){
        mPresenter.showProductListResult(new ArrayList<Product>());
        verify(mView,times(1)).showEmptyState();
    }
    @Test
    public void testIfEmptyStateIsNotCalledForPopulatedList(){
        ArrayList<Product> result = new ArrayList<>();
        result.add(product);
        mPresenter.showProductListResult(result);
        verify(mView,never()).showEmptyState();
    }

    @Test
    public void testIfShowResultsIsCalledForNonEmptyList(){
        ArrayList<Product> result = new ArrayList<>();
        result.add(product);
        mPresenter.showProductListResult(result);
        verify(mView,times(1)).showResults(anyList());
    }

}
