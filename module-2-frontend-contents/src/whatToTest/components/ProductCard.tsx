import React from 'react';
import {Product} from "../types/Product.ts";

type ProductCardProps = { product: Product };
const ProductCard: React.FC<ProductCardProps> = ({product}) => {
    return (
        <div>
            <h3>{product.name}</h3>
            <p>{product.description}</p>
            <img src={product.image} alt={product.name}/>
            <span>${product.price}</span>
        </div>
    );
};

export default ProductCard;