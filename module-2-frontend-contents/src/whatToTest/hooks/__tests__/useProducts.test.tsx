import { QueryClientProvider } from "@tanstack/react-query";
import { renderHook, waitFor } from "@testing-library/react";
import { afterEach, describe, expect, it, vi } from "vitest";
import { queryClient } from "../../../lib/react-query";
import * as api from "../../http/api.ts";
import { Product } from "../../types/Product.ts";
import { useProducts } from "../useProducts.ts";

describe("useProducts", () => {
    afterEach(() => {
        vi.clearAllMocks();
    });

    const newProduct = {
        description: "Product description",
        name: "Product name",
        image: "https://example.com/image.png",
        price: 10,
    };

    it("should create a product and refetch products", async () => {
        const createProductRequest = vi.fn();
        const getProductsRequest = vi.fn();
        vi.spyOn(api, "getProductsRequest").mockImplementation(getProductsRequest);
        vi.spyOn(api, "createProductRequest").mockImplementation(createProductRequest);

        const { result } = renderHook(() => useProducts(), {
            wrapper: ({ children }) => <QueryClientProvider client={queryClient}>{children}</QueryClientProvider>,
        });
        await result.current.createProduct(newProduct);

        expect(createProductRequest).toHaveBeenCalled();
        expect(getProductsRequest).toHaveBeenCalled();
    });

    it("should load the list of products", async () => {
        const products: Product[] = [
            {
                id: "6b0553d8-a045-48c7-8e5b-0fe3c9c3e83b",
                ...newProduct,
            },
            {
                id: "8d6eb0af-34a6-40bf-9ecb-7e384e220763",
                ...newProduct,
            },
        ];
        const getProductsRequest = vi.fn().mockResolvedValue(products);
        vi.spyOn(api, "getProductsRequest").mockImplementation(getProductsRequest);

        const { result } = renderHook(() => useProducts(), {
            wrapper: ({ children }) => <QueryClientProvider client={queryClient}>{children}</QueryClientProvider>,
        });

        await waitFor(() => {
            console.log(result.current.products);
            expect(result.current.products).toEqual(products);
        });
    });
});
