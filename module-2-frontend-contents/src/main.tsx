import {StrictMode} from 'react'
import {createRoot} from 'react-dom/client'
import App from './App.tsx'
import {createBrowserRouter, RouterProvider} from "react-router-dom"
import ProductsPage from "./whatToTest/pages/ProductsPage.tsx";
import {QueryClientProvider} from "@tanstack/react-query";
import TodosPage from "./whatWouldYouTest/pages/TodosPage.tsx";
import {queryClient} from "./lib/react-query";
import {TodoContextProvider} from "./whatWouldYouTest/contexts/TodoContextProvider.tsx";


const router = createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        children: [
            {
                path: "/products",
                element:
                    <ProductsPage/>
            },
            {
                path: "/todos",
                element: <TodoContextProvider children={<TodosPage/>}/>
            }
        ]
    }
])

createRoot(document.getElementById('root')!).render(
    <StrictMode>
        <QueryClientProvider client={queryClient}>
            <RouterProvider router={router}/>
        </QueryClientProvider>
    </StrictMode>,
)
