import React, {useState} from 'react';
import {useProducts} from "../hooks/useProducts.ts";
import {NewProduct} from "../types/NewProduct.ts";

const ProductForm: React.FC = () => {
    const [newProduct, setNewProduct] = useState<NewProduct>({
        name: "",
        description: "",
        price: 0,
        image: "",
    })
    const {createProduct} = useProducts();

    const handleFormChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setNewProduct(currentNewProduct => {
            return ({
                ...currentNewProduct,
                [event.target.id]: event.target.type === "number" ? Number(event.target.value) : event.target.value
            })
        })
    }

    const handleFormSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        await createProduct(newProduct)
    }

    return (
        <form onSubmit={handleFormSubmit}>
            <h2>Create a product</h2>
            <label htmlFor="name">What's the name of the product?</label>
            <input onChange={handleFormChange} id="name" type="text"/>
            <label htmlFor="description">How would you describe the product?</label>
            <input onChange={handleFormChange} id="description" type="text"/>
            <label htmlFor="price">How much does the product cost?</label>
            <input onChange={handleFormChange} id="price" type="number"/>
            <label htmlFor="image">What's the link to the product image?</label>
            <input onChange={handleFormChange} id="image" type="text"/>
            <button type="submit">Save product</button>
        </form>
    );
};

export default ProductForm;