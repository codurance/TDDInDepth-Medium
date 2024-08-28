import React from 'react';
import ProductForm from "../components/ProductForm.tsx";
import ProductsList from "../components/ProductsList.tsx";
import {useProducts} from "../hooks/useProducts.ts";

const ProductsPage: React.FC = () => {
    const {products} = useProducts();

    return (
        <div>
            <h1>Products</h1>
            <ProductForm/>
            <ProductsList products={products ?? []} />
        </div>
    );
};

export default ProductsPage;