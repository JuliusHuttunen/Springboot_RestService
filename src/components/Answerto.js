import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';


export default function Answerto(props) {
    const [open, setOpen] = React.useState(false);
    const [value, setValue] = React.useState(null);
    const [question, setQuestion] = React.useState({
        qst: '', qsttype: '', answer: ''
    })

    const handleChange = (event) => {
        console.log(value);
        setValue(event.target.value);
        setQuestion({
            qst: props.question.qst, qsttype: props.question.qsttype,
            answer: value
        })
    };

    const handleClickOpen = () => {
        console.log(props.question);
        setQuestion({
            qst: props.question.qst, qsttype: props.question.qsttype,
            answer: props.question.answer
        })
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleInputChange = (e) => {
        setQuestion({ ...question, [e.target.name]: e.target.value })
    }

    const updateQuestion = () => {
        props.updateQuestion(question, props.question._links.question.href);
        handleClose();
    }


    if (props.question.qsttype === "number") {

        return (
            <div>
                <Button color="primary" onClick={handleClickOpen}>
                    Answer
            </Button>
                <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
                    <DialogTitle id="form-dialog-title">{props.question.qst}</DialogTitle>
                    <DialogContent>
                        <TextField
                            margin="dense"
                            type="number"
                            name="answer"
                            value={question.answer}
                            onChange={e => handleInputChange(e)}
                            label="Your answer"
                            fullWidth
                        />
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={handleClose} color="primary">
                            Cancel
                        </Button>
                        <Button onClick={updateQuestion} color="primary">
                            Save answer
                        </Button>
                    </DialogActions>
                </Dialog>
            </div>
        );
    }

    else if (props.question.qsttype === "radio") {
        return (
            <div>
                <Button color="primary" onClick={handleClickOpen}>
                    Answer
            </Button>
                <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
                    <DialogTitle id="form-dialog-title">{props.question.qst}</DialogTitle>
                    <DialogContent>
                        <FormControl component="fieldset">
                            <FormLabel component="legend">Your answer</FormLabel>
                            <RadioGroup row aria-label="gender" name="gender1" value={value} onChange={event => handleChange(event)}>
                                <FormControlLabel value='1' control={<Radio />} label="1" />
                                <FormControlLabel value='2' control={<Radio />} label="2" />
                                <FormControlLabel value='3' control={<Radio />} label="3" />
                                <FormControlLabel value='4' control={<Radio />} label="4" />
                                <FormControlLabel value='5' control={<Radio />} label="5" />
                            </RadioGroup>
                        </FormControl>
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={handleClose} color="primary">
                            Cancel
                        </Button>
                        <Button onClick={updateQuestion} color="primary">
                            Save answer
                        </Button>
                    </DialogActions>
                </Dialog>
            </div>
        );
    }
    else {

        return (
            <div>
                <Button color="primary" onClick={handleClickOpen}>
                    Answer
            </Button>
                <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
                    <DialogTitle id="form-dialog-title">Vastaus</DialogTitle>
                    <DialogContent>
                        <TextField
                            margin="dense"
                            name="answer"
                            value={question.answer}
                            onChange={e => handleInputChange(e)}
                            label="Your answer"
                            fullWidth
                        />
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={handleClose} color="primary">
                            Cancel
                        </Button>
                        <Button onClick={updateQuestion} color="primary">
                            Save answer
                        </Button>
                    </DialogActions>
                </Dialog>
            </div>
        )
    }
}
