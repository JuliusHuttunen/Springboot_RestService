import React, {useState, useEffect} from 'react';

export default function Questionlist() {
    const [questions, setQuestions] = useState([]);

    useEffect(() => fetchData(), []);

    const fetchData = () => {
        fetch('https://cors-anywhere.herokuapp.com/https://questionnaire-rest.herokuapp.com/api/questions')
        .then(response => response.json())
        .then(data => setQuestions(data._embedded.questions))
    }
    return (
        <div></div>
    );
}
