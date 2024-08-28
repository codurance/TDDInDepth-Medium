import {StrictMode} from 'react'
import {createRoot} from 'react-dom/client'
import App from './App.tsx'
import {createBrowserRouter, RouterProvider} from "react-router-dom"
import ProductsPage from "./whatToTest/pages/ProductsPage.tsx";
import {QueryClientProvider} from "@tanstack/react-query";
import {queryClient} from "./whatToTest/components/lib/react-query";


const router = createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        children: [
            {
                path: "/products",
                element: <QueryClientProvider client={queryClient}>
                    <ProductsPage/>,
                </QueryClientProvider>
            }
        ]
    }
])

createRoot(document.getElementById('root')!).render(
    <StrictMode>
        <RouterProvider router={router}/>
    </StrictMode>,
)
