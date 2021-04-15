import React from "react";
import {Link} from "react-router-dom";

const Book = (props) => {
    return (
        <tr>
            <td>{props.book.name}</td>
            <td>{props.book.category}</td>
            <td>{props.book.author.name}</td>
            <td>{props.book.availableCopies}</td>
            <td>
                <div className={"d-flex justify-content-around pl-5 pr-5"}>
                    <div title={"Mark"} className={"btn btn-primary"}
                         onClick={() => props.onMark(props.book.id)}
                    >Mark Taken</div>
                    <Link onClick={async () => props.onEdit(props.book.id)}
                          className={"btn btn-primary"}
                          to={`/books/edit/${props.book.id}`}>Edit</Link>
                    <div title={"Delete"} className={"btn btn-danger"}
                         onClick={() => props.onDelete(props.book.id)}
                    >Delete</div>
                </div>

            </td>
        </tr>
    )
}

export default Book;