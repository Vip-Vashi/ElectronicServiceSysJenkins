package com.micro.electronicappliance.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.micro.electronicappliance.model.PurchasedProduct;
import com.micro.electronicappliance.repo.PurchasedProductRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PurchasedProductServiceImplTest {

    @Mock
    private PurchasedProductRepo repo;

    @InjectMocks
    private PurchasedProductServiceImpl purchasedProductService;

    private PurchasedProduct purchasedProduct;

    @BeforeEach
     void setUp() {
        purchasedProduct = new PurchasedProduct(1, "SN12345", LocalDate.now(), "Main Branch", new byte[]{1, 2, 3}, null, null);
    }

    @Test
     void testSave() {
        when(repo.save(any(PurchasedProduct.class))).thenReturn(purchasedProduct);

        PurchasedProduct savedProduct = purchasedProductService.save(purchasedProduct);

        assertNotNull(savedProduct);
        assertEquals(purchasedProduct.getProductId(), savedProduct.getProductId());
        verify(repo, times(1)).save(any(PurchasedProduct.class));
    }

    @Test
     void testGetById() {
        when(repo.findProductById(1)).thenReturn(purchasedProduct);

        PurchasedProduct foundProduct = purchasedProductService.getById(1);

        assertNotNull(foundProduct);
        assertEquals(purchasedProduct.getSerialnum(), foundProduct.getSerialnum());
        verify(repo, times(1)).findProductById(1);
    }

    @Test
     void testGetAll() {
        List<PurchasedProduct> products = new ArrayList<>();
        products.add(purchasedProduct);
        when(repo.findAllProducts()).thenReturn(products);

        List<PurchasedProduct> foundProducts = purchasedProductService.getAll();

        assertFalse(foundProducts.isEmpty());
        assertEquals(1, foundProducts.size());
        assertEquals(purchasedProduct.getSerialnum(), foundProducts.get(0).getSerialnum());
        verify(repo, times(1)).findAllProducts();
    }

    @Test
     void testDeleteById() {
        doNothing().when(repo).deleteProductById(1);

        assertDoesNotThrow(() -> purchasedProductService.deleteById(1));
        verify(repo, times(1)).deleteProductById(1);
    }
}
