import React from "react";
import Book from "./Book";
import {Link} from "react-router-dom";

const books = (props) => {
    return(
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table text-center"}>
                        <thead className={"thead-light"}>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>category</th>
                            <th scope={"col"}>Author</th>
                            <th scope={"col"}>availableCopies</th>
                            <th scope={"col"}>
                                <Link className={"btn btn-primary"} to={'/books/add'}>Add</Link>
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.books.map((book) => {
                            return (
                                <Book book={book} onAdd={props.addBook}  onMark={props.onMark} onEdit={props.onEdit} onDelete={props.onDelete} />
                            )
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    )
}

export default books;