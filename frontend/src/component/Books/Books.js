import React from "react";
import ReactPaginate from 'react-paginate'
import Book from "./Book";
import {Link} from "react-router-dom";

class Books extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            page: 0,
            size: 5
        }
    }

    render() {

        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size

        const books = this.BookPage(offset, nextPageOffset);

        const pageCount = Math.ceil(this.props.books.length / this.state.size)

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
                                {books}
                            </tbody>
                        </table>
                    </div>
                </div>
                <div className={'row'}>
                    <div className={'col-md-6 offset-3'}>
                        <ReactPaginate previousLabel={'back'}
                                       nextLabel={'next'}
                                       breakLabel={<a href={'/#'}>...</a>}
                                       breakClassName={'break-me'}
                                       pageClassName={'mx-1 py-2'}
                                       pageCount={pageCount}
                                       marginPageDisplayed={2}
                                       pageRangeDisplayed={5}
                                       onPageChange={this.pageChangeHandler}
                                       containerClassName={'pagination m-4 justify-content-center'}
                                       activeClassName={'active'}
                                       previousClassName={'btn btn-primary'}
                                       nextClassName={'btn btn-primary'}/>
                    </div>
                </div>
            </div>
        )
    }

    pageChangeHandler = (data) => {
        let selected = data.selected;
        this.setState({
            page: selected
        })
    }

    BookPage = (offset, nextPageOffset) => {
        return this.props.books.map((book) =>{
            return (
                <Book book={book} onAdd={this.props.addBook}  onMark={this.props.onMark} onEdit={this.props.onEdit} onDelete={this.props.onDelete} />
            )
        }).filter((value,index) => index >= offset && index < nextPageOffset );
    }

}

export default Books;