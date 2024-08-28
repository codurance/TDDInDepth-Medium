import {render, screen} from "@testing-library/react";
import ProductForm from "../ProductForm.tsx";
import {userEvent} from "@testing-library/user-event";
import {vi, describe, it, expect, afterEach} from "vitest";
import * as useProductsHook from "../../hooks/useProducts.ts"
import {QueryClientProvider} from "@tanstack/react-query";
import {queryClient} from "../../../lib/react-query";

describe("ProductsForm", () => {
    afterEach(() => {
        vi.clearAllMocks()
    })

    it("should allow the user to save a product", async () => {
        const createProduct = vi.fn();
        vi.spyOn(useProductsHook, "useProducts").mockImplementation(() => {
            return {
                createProduct,
                getProducts: vi.fn(),
                products: [],
            }
        })
        const newProduct = {
            description: "Product description",
            name: "Product name",
            image: "https://example.com/image.png",
            price: 10
        }

        render(<ProductForm/>, {
            wrapper: ({children}) => (<QueryClientProvider client={queryClient}>{children}</QueryClientProvider>
        )});

        const nameField = screen.getByLabelText("What's the name of the product?")
        const descriptionField = screen.getByLabelText("How would you describe the product?")
        const priceField = screen.getByLabelText("How much does the product cost?")
        const imageField = screen.getByLabelText("What's the link to the product image?")
        const createProductButton = screen.getByRole("button", {name: "Save product"})

        await userEvent.type(nameField, newProduct.name);
        await userEvent.type(descriptionField, newProduct.description);
        await userEvent.type(priceField, String(newProduct.price));
        await userEvent.type(imageField, newProduct.image);

        await userEvent.click(createProductButton);

        expect(createProduct).toHaveBeenCalledWith(newProduct);
    })
})