import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';

export default function Answerto(props) {
    const [open, setOpen] = React.useState(false);
    const [question, setQuestion] = React.useState({
        qst:'', qsttype:'', answer: ''
    })
    const handleClickOpen = () => {
        console.log(props.question);
        setQuestion({qst: props.question.qst, qsttype: props.question.qsttype, answer: props.question.answer})
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleInputChange = (e) => {
        setQuestion({...question, [e.target.name]: e.target.value})
    }

    const updateQuestion = () => {
        props.updateQuestion(question, props.question._links.question.href);
        handleClose();
    }

    return(
        <div>
            <Button variant="outlined" color="primary" onClick={handleClickOpen}>
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
    );
}
