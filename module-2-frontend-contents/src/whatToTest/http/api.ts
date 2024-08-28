import * as axios from "axios";
import {NewProduct} from "../types/NewProduct.ts";
import {Product} from "../types/Product.ts";
import {generateId} from "./generateId.ts";


const request = axios.default.create({
    baseURL: "http://localhost:5000",
})

export const createProductRequest = async (product: NewProduct): Promise<Product> => {
    const {data} = await request.post<Product>("/products", {
        id: generateId(),
        ...product,
    });

    return data;
}

export const getProductsRequest = async (): Promise<Product[]> => {
    const {data} = await request.get<Product[]>("/products");

    return data;
}