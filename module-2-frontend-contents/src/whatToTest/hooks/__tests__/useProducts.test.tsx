import {useProducts} from "../useProducts.ts";
import {renderHook, waitFor} from "@testing-library/react";
import * as api from "../../http/api.ts";
import {vi, describe, it, expect, afterEach} from "vitest";
import {Product} from "../../types/Product.ts";
import {QueryClientProvider} from "@tanstack/react-query";
import {queryClient} from "../../components/lib/react-query";

describe("useProducts", () => {
    afterEach(() => {
        vi.clearAllMocks()
    })

    const newProduct = {
        description: "Product description",
        name: "Product name",
        image: "https://example.com/image.png",
        price: 10
    };

    it("should create a product", async () => {
        const createProductRequest = vi.fn()
        vi.spyOn(api, "createProductRequest").mockImplementation(createProductRequest)

        const {result} = renderHook(() => useProducts(), {
            wrapper: ({children}) => (<QueryClientProvider client={queryClient}>{children}</QueryClientProvider>)
        });
        await result.current.createProduct(newProduct)

        expect(createProductRequest).toHaveBeenCalled()
    })

    it("should load the list of products", async () => {
        const products: Product[] = [
            {
                id: "6b0553d8-a045-48c7-8e5b-0fe3c9c3e83b",
                ...newProduct,
            },
            {
                id: "8d6eb0af-34a6-40bf-9ecb-7e384e220763",
                ...newProduct,
            }
        ];
        const getProductsRequest = vi.fn().mockResolvedValue(products)
        vi.spyOn(api, "getProductsRequest").mockImplementation(getProductsRequest)

        const {result} = renderHook(() => useProducts(), {
            wrapper: ({children}) => (<QueryClientProvider client={queryClient}>{children}</QueryClientProvider>)
        });

        await waitFor(() => {
            expect(result.current.products).toEqual(products);
        })
    })
})

