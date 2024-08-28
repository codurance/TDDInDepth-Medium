import {defineConfig} from "cypress";

export default defineConfig({
    chromeWebSecurity: false,
    e2e: {
        baseUrl: "http://localhost:5173",
        setupNodeEvents(on, config) {
            // implement node event listeners here
        },
        // uncomment this line to set a spec pattern for e2e tests with cypress
        // specPattern: "cypress/**/*.feature.ts"
    }
});
