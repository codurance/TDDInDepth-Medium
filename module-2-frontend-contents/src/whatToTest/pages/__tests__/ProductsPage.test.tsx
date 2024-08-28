import {afterEach, beforeAll, describe, expect, it} from "vitest";
import ProductsPage from "../ProductsPage.tsx";
import {render, screen} from "@testing-library/react";
import {setupServer} from "msw/node";
import {http, HttpResponse, PathParams} from "msw";
import {Product} from "../../types/Product.ts";
import {userEvent} from "@testing-library/user-event";
import {QueryClientProvider} from "@tanstack/react-query";
import {queryClient} from "../../../lib/react-query";


describe("ProductsPage", () => {
    let products: Product[] = []

    beforeAll(() => {
        const server = setupServer(
            http.get("http://localhost:5000/products", () => {
                return HttpResponse.json(products);
            }),
            http.post<PathParams, Product>("http://localhost:5000/products", async ({request}) => {
                const product = await request.json();

                products.push(product);

                return HttpResponse.json(product);
            })
        );
        server.listen()
    })

    afterEach(() => {
        products = [];
    })

    it("should create and display products", async () => {
        render(<ProductsPage/>, {
            wrapper: ({children}) => (<QueryClientProvider client={queryClient}>{children}</QueryClientProvider>)
        });

        const newProduct = {
            description: "Product description",
            name: "Product name",
            image: "https://example.com/image.png",
            price: 10
        }

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

        const createdProduct = await screen.findByRole("heading", {level: 3, name: newProduct.name})

        expect(createdProduct).toBeVisible();
    })
})
