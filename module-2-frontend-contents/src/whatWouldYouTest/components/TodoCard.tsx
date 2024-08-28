import Card from '@mui/material/Card';
import Typography from '@mui/material/Typography';
import FormControl from '@mui/material/FormControl';
import InputLabel from '@mui/material/InputLabel';
import Select, {SelectChangeEvent} from '@mui/material/Select';
import MenuItem from '@mui/material/MenuItem';
import Divider from '@mui/material/Divider';
import {useState} from 'react';
import {Todo} from "../types/Todo.ts";

type TodoCardProps = {
  todo: Todo;
  onStatusChange: (todo: Todo) => void;
};

export const TodoCard = ({todo, onStatusChange}: TodoCardProps) => {
  const [status, setStatus] = useState<Todo['status']>(todo.status);

  const handleStatusChange = (event: SelectChangeEvent<Todo['status']>) => {
      const newStatus = event.target.value as Todo['status'];
      setStatus(newStatus);
    onStatusChange({
      ...todo,
      status: newStatus,
    });
  };

  return <Card sx={{padding: '1rem', display: 'flex', flexDirection: 'column', gap: '1rem', flex: 1}}>
    <Typography component="h3" variant="h5">
      {todo.title}
    </Typography>
    <Divider sx={{flex: 1}} />
    <Typography component="p">
      {todo.description}
    </Typography>
    <FormControl sx={{alignSelf: 'end'}}>
      <InputLabel>Status</InputLabel>
      <Select value={status} label="Status" onChange={handleStatusChange}>
        <MenuItem value={'todo'}>To do</MenuItem>
        <MenuItem value={'doing'}>Doing</MenuItem>
        <MenuItem value={'done'}>Done</MenuItem>
      </Select>
    </FormControl>

  </Card>;
};