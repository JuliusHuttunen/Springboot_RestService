import React, {useState, useEffect} from 'react';
import ReactTable from 'react-table-v6';
import 'react-table-v6/react-table.css';
import Answerto from './Answerto';
export default function Questionlist() {
    const [questions, setQuestions] = useState([]);

    useEffect(() => fetchData(), []);

    let url = 'https://cors-anywhere.herokuapp.com/';

    const fetchData = () => {
        fetch('https://cors-anywhere.herokuapp.com/https://questionnaire-rest.herokuapp.com/api/questions')
        .then(response => response.json())
        .then(data => setQuestions(data._embedded.questions))
    }

    const saveQuestion = (question) => {
        fetch('https://cors-anywhere.herokuapp.com/https://questionnaire-rest.herokuapp.com/api/questions', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body : JSON.stringify(question)
            })
            .then(res => fetchData())
            .catch(err => console.error(err))
    } 

    const updateQuestion = (question, link) => {
        fetch( url + link, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(question)
        })
        .then(res => fetchData())
        .catch(err => console.error(err))
    }

    const columns = [
        {
            Header: 'Question',
            accessor: 'qst'
        },
        {
            Header: 'Answer',
            accessor: 'answer'
        },
        {
            filterable: false,
            sortable: false,
            width: 100,
            Cell: row => <Answerto updateQuestion={updateQuestion} question={row.original}/>

        },
    ]
    return (
        <div>
            <ReactTable data={questions} columns={columns}/>
        </div>
    );
}
