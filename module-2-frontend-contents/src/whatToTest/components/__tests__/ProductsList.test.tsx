import {it, expect, describe, vi, afterEach} from "vitest";
import {render, screen} from "@testing-library/react";
import ProductsList from "../ProductsList.tsx";

describe("ProductsList", () => {
    afterEach(() => {
        vi.clearAllMocks()
    })

    it("should display a list of products", () => {
        const products = [
            {
                id: "6b0553d8-a045-48c7-8e5b-0fe3c9c3e83b",
                description: "Product description",
                name: "Product name",
                image: "https://example.com/image.png",
                price: 10
            },
            {
                id: "8d6eb0af-34a6-40bf-9ecb-7e384e220763",
                description: "Product description",
                name: "Product name",
                image: "https://example.com/image.png",
                price: 10
            }];

        render(<ProductsList products={products}/>)

        const renderedProducts = screen.getAllByRole("listitem");

        expect(renderedProducts).toHaveLength(products.length);
    })
})