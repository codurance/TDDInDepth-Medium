import {NewProduct} from "../types/NewProduct.ts";
import {createProductRequest, getProductsRequest} from "../http/api.ts";
import {Product} from "../types/Product.ts";
import {useMutation, useQuery} from "@tanstack/react-query";
import {QUERY_KEYS} from "../../lib/react-query";

export const useProducts = () => {
    const {mutateAsync} = useMutation({mutationFn: createProductRequest})
    const {data, refetch} = useQuery<Product[]>({queryKey: [QUERY_KEYS.GET_PRODUCTS], queryFn: getProductsRequest});
    const createProduct = async (newProduct: NewProduct) => {
        await mutateAsync(newProduct)
        await refetch()
    }

    const getProducts = () => {
    }

    return {products: data, createProduct, getProducts}
}