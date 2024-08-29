import {Button, Drawer, TextField} from "@mui/material";
import Box from "@mui/material/Box";
import React, {useContext, useState} from "react";
import {PlusIcon} from "./PlusIcon.tsx";
import {TodoContext} from "../contexts/TodoContext.ts";
import {NewTodo} from "../types/NewTodo.ts";

export const TodoForm = () => {
    const {createTodo} = useContext(TodoContext);
    const [isOpen, setIsOpen] = useState(false)
    const [newTodo, setNewTodo] = useState<NewTodo>({
        description: "", title: ""
    })

    const toggleDrawer = () => setIsOpen(!isOpen);

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        console.log(event);
        setNewTodo(prevState => ({
            ...prevState,
            [event.target.id]: event.target.value
        }));
    }

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        await createTodo(newTodo);
        toggleDrawer();
        setNewTodo({
            description: "", title: ""
        });
    };

    return (
        <>
            <Button sx={{
                borderRadius: "50%",
                aspectRatio: 1,
                padding: "1rem",
                minWidth: "unset",
                position: "fixed",
                bottom: "2rem",
                right: "2rem",
                zIndex: 100
            }} variant="contained" color="primary" onClick={toggleDrawer} aria-label="Add todo">
                <PlusIcon/>
            </Button>
            <Drawer
                PaperProps={{sx: {width: "50%", display: "flex", flexDirection: "column", justifyContent: "center"}}}
                anchor="right" sx={{}} open={isOpen} onClose={toggleDrawer}>
                <Box component="form"
                     onSubmit={handleSubmit}
                     sx={{
                         display: "flex",
                         flexDirection: "column",
                         gap: "1rem",
                         padding: "1rem",
                     }}>
                    <TextField id="title" label="Title" value={newTodo.title} required onChange={handleChange}/>
                    <TextField id="description" label="Description" rows={4} value={newTodo.description} required
                               multiline onChange={handleChange}/>
                    <Box component="div" sx={{display: "flex", gap: "1rem"}}>
                        <Button sx={{flex: 1}} variant="outlined" type="button" onClick={toggleDrawer}>Cancel</Button>
                        <Button sx={{flex: 1}} variant="contained" type="submit">Create todo</Button>
                    </Box>
                </Box>
            </Drawer>
        </>
    )
}