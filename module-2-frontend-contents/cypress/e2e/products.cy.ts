import {NewProduct} from "../../src/whatToTest/types/NewProduct.ts";
import {Product} from "../../src/whatToTest/types/Product.ts";

describe('given a user navigates to the products page', () => {
    describe("when they create a Television product", () => {
        it('then they should be able to see the created product in the list of products', async () => {
            const products: Product[] = []
            cy.intercept({
                method: 'POST',
                url: 'http://localhost:5000/products',
            }, req => {
                products.push(req.body)
                req.reply({
                    body: req.body
                })
            });

            cy.intercept({
                method: 'GET',
                url: 'http://localhost:5000/products',
            }, (req) => {
                req.reply({
                    body: products
                })
            })

            const television: NewProduct = {
                name: "Television",
                description: "52 inch ultra high definition",
                price: 500,
                image: "https://examples.com/image.png"
            }

            cy.visit("/products");
            cy.findByRole("heading", {level: 1, name: "Products"}).should("be.visible");

            cy.findByLabelText("What's the name of the product?")
                .type(television.name);
            cy.findByLabelText("How would you describe the product?")
                .type(television.description);
            cy.findByLabelText("How much does the product cost?")
                .type(television.price.toString());
            cy.findByLabelText("What's the link to the product image?")
                .type(television.image);
            cy.findByRole("button", {
                name: "Save product"
            }).click()

            cy.findByRole("heading", {level: 3, name: television.name}).should("be.visible")
            cy.findByRole("img", {name: television.name}).should("be.visible");
        })
    })
})