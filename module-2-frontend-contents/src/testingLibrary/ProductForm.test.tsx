import {fireEvent, render, screen, waitFor} from "@testing-library/react";
import ProductForm from "../whatToTest/components/ProductForm.tsx";
import {userEvent} from "@testing-library/user-event";
import {afterEach, describe, expect, it, vi} from "vitest";
import {QueryClientProvider} from "@tanstack/react-query";
import {queryClient} from "../lib/react-query";
import * as useProductsHook from "../whatToTest/hooks/useProducts.ts";

describe("ProductsForm", () => {
    afterEach(() => {
        vi.clearAllMocks()
    })

    it("using find, get, and query", async () => {
        render(<ProductForm/>, {
            wrapper: ({children}) => (<QueryClientProvider client={queryClient}>{children}</QueryClientProvider>
            )
        });

        // this with throw if it can't find the element
        const nameField = screen.getByLabelText("What's the name of the product?")
        // this will return null if it can't find the element
        // it is recommended to use query only to check for non existence
        const descriptionField = screen.queryByLabelText("How would you describe the product?")
        // this will retry until it finds the element
        const priceField = await screen.findByLabelText("How much does the product cost?")

        expect(nameField).toBeVisible()
        expect(descriptionField).toBeVisible()
        expect(priceField).toBeVisible()
    })

    it("get and waitFor", async () => {
        render(<ProductForm/>, {
            wrapper: ({children}) => (<QueryClientProvider client={queryClient}>{children}</QueryClientProvider>
            )
        });

        // use find instead of waiting for a get
        const nameField = await waitFor(() => screen.getByLabelText("What's the name of the product?"));
        expect(nameField).toBeVisible()

        const descriptionField = await screen.findByLabelText("How would you describe the product?")
        expect(descriptionField).toBeVisible()
    })

    it("using userEvent and fireEvent", async () => {
        render(<ProductForm/>, {
            wrapper: ({children}) => (<QueryClientProvider client={queryClient}>{children}</QueryClientProvider>
            )
        });

        // use userEvent instead of fireEvent unless you need to use the dispatch event API
        const nameField = screen.getByLabelText("What's the name of the product?")
        fireEvent.change(nameField, {target: {value: "Product name"}})

        await userEvent.type(nameField, "Product name");
    })

    it("using toBeInTheDocument and toBeVisible", () => {

    })

    it("using too many assertions", async () => {
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
            )
        });

        const nameField = screen.getByLabelText("What's the name of the product?")
        expect(nameField).toBeVisible();
        const descriptionField = screen.getByLabelText("How would you describe the product?")
        expect(descriptionField).toBeVisible();
        const priceField = screen.getByLabelText("How much does the product cost?")
        expect(priceField).toBeVisible();
        const imageField = screen.getByLabelText("What's the link to the product image?")
        expect(imageField).toBeVisible();
        const createProductButton = screen.getByRole("button", {name: "Save product"})
        expect(createProductButton).toBeVisible();

        await userEvent.type(nameField, newProduct.name);
        expect(nameField).toHaveValue(newProduct.name);
        await userEvent.type(descriptionField, newProduct.description);
        expect(descriptionField).toHaveValue(newProduct.description);
        await userEvent.type(priceField, String(newProduct.price));
        expect(priceField).toHaveValue(newProduct.price);
        await userEvent.type(imageField, newProduct.image);
        expect(imageField).toHaveValue(newProduct.image);

        await userEvent.click(createProductButton);

        expect(createProduct).toHaveBeenCalledWith(newProduct);
    })
})