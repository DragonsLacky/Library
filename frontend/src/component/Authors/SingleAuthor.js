import React from "react";

const Author = (props) => {
    return (
        <tr>
            <td>{props.author.name}</td>
            <td>{props.author.surname}</td>
            <td>{props.author.country.name}</td>
        </tr>
    )
}

export default Author;