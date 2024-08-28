import {QueryClient} from "@tanstack/react-query";

export const queryClient = new QueryClient({
    defaultOptions: {
        queries: {
            refetchOnWindowFocus: false,
            retry: 0,
        },
    },
});

export const QUERY_KEYS = {
    GET_PRODUCTS: "GET_PRODUCTS",
    GET_TODOS: "GET_TODOS",
} as const;

const queryKeyValues = Object.values(QUERY_KEYS);

if (new Set(queryKeyValues).size !== queryKeyValues.length) {
    throw new Error('Duplicate QUERY_KEYS');
}