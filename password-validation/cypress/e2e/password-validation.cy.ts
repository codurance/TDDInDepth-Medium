describe('given a user has chosen standard validation', () => {
    describe("when they validate \"Passw0rd_\"", () => {
        it('then they should not see an invalid messgage', () => {
            cy.visit('/')

            cy.findByLabelText("What validation strategy do you want to use?").select("Standard")
            cy.findByLabelText("What's the password you want to validate?").type("Passw0rd_")
            cy.findByRole("button", {name: "Validate"}).click()

            cy.findByText("Invalid").should("not.exist")
        })
    })

    describe("when they validate \"Passw0_\"", () => {
        it('then they should see an invalid messgage', () => {
            cy.visit('/')

            cy.findByLabelText("What validation strategy do you want to use?").select("Standard")
            cy.findByLabelText("What's the password you want to validate?").type("Passw0_")
            cy.findByRole("button", {name: "Validate"}).click()

            cy.findByText("Invalid").should("be.visible")
        })
    })
})

describe("given a user has chosen short validation", () => {
    describe("when they validate \"Passw0r\"", () => {
        it('then they should not see an invalid message', () => {
            cy.visit('/')

            cy.findByLabelText("What validation strategy do you want to use?").select("Short")
            cy.findByLabelText("What's the password you want to validate?").type("Passw0r")
            cy.findByRole("button", {name: "Validate"}).click()

            cy.findByText("Invalid").should("not.exist")
        })
    })

    describe("when they validate \"Pass0\"", () => {
        it('then they should not see an invalid message', () => {
            cy.visit('/')

            cy.findByLabelText("What validation strategy do you want to use?").select("Short")
            cy.findByLabelText("What's the password you want to validate?").type("Pass0")
            cy.findByRole("button", {name: "Validate"}).click()

            cy.findByText("Invalid").should("be.visible")
        })
    })
})