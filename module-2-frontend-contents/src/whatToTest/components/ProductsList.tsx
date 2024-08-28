import React from 'react';
import ProductCard from "./ProductCard.tsx";
import {Product} from "../types/Product.ts";

type ProductsListProps = { products: Product[] };
const ProductsList: React.FC<ProductsListProps> = ({products}) => {

    return (
        <>
            <h2>Products list</h2>
            <ul>
                {products.map((product) => (
                    <li key={product.id}>
                        <ProductCard product={product}/>
                    </li>
                ))}
            </ul>
        </>
    );
};

export default ProductsList;