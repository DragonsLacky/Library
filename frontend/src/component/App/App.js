import './App.css';
import React,{Component} from 'react';
import {Route, Switch} from 'react-router-dom';
import {BookRepository, CategoryRepository, AuthorRepository} from '../../Repository/Repository';
import Books from '../Books/Books';
import AddBook from "../Books/AddBook";
import EditBook from "../Books/EditBook"
import Navigation from '../Header/nav.js'
import Categories from "../Categories/Categories";
import Authors from "../Authors/ListAuthors";


class App extends Component{
    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: [],
            authors: [],
            selectedBook: {}
        }
    }

    componentDidMount() {
        this.loadBooks();
        this.loadCategories();
        this.loadAuthors();
    }

    render() {
        return(
                <main className={"container-fluid"}>
                    <Navigation />
                    <Switch>
                        <Route path={"/books/add"}
                               exact
                               render={() => (
                                   <AddBook onAddBook={this.addBook}  categories={this.state.categories} authors={this.state.authors} />
                               )}/>onEditBook
                        <Route path={"/books/edit/:id"}
                               exact
                               render={() => (
                                   <EditBook book={this.state.selectedBook} onEditBook={this.editBook} categories={this.state.categories} authors={this.state.authors} />
                               )}/>
                        <Route path={"/books"}
                               exact
                               render={() => (
                                   <Books books={this.state.books} onMark={this.markBook} onEdit={this.getBook} onDelete={this.deleteBook} />
                               )}/>
                        <Route path={"/categories"}
                               exact
                               render={() => (
                                    <Categories categories={this.state.categories} />
                               )}/>
                        <Route path={"/authors"}
                               exact
                               render={() => (
                                   <Authors authors={this.state.authors}/>
                               )}/>
                        <Route path={"/"}
                               exact
                               render={() => (
                                   <Books books={this.state.books} />
                               )}/>
                    </Switch>
                </main>
        )
    }

    loadBooks = () => {
        BookRepository.fetchBooks().then((data) => {
            this.setState({
                books: data.data
            })
        })
    }

    addBook =  (name, category, author, availableCopies) => {
        BookRepository.addBook(name, category, author, availableCopies).then(() => {
            this.loadBooks()
        })
    }

    markBook = (id) => {
        BookRepository.markBook(id).then(() => {
            this.loadBooks()
        })
    }

    editBook = (id, name, category, author, availableCopies) => {
        BookRepository.editBook(id, name, category, author, availableCopies).then(() => {
            this.loadBooks()
        })
    }

    deleteBook = (id) => {
        BookRepository.deleteBook(id).then(() => {
            this.loadBooks()
        })
    }

    loadCategories = () => {
        CategoryRepository.fetchCategories().then((data) => {
            this.setState({
                categories: data.data
            })
        })
    }

    loadAuthors = () => {
        AuthorRepository.fetchAuthors().then((data) => {
            this.setState({
                authors: data.data
            })
        })
    }

    getBook = (id) => {
        BookRepository.getBook(id).then((data) => {
            this.setState({
                selectedBook: data.data
            })
        })
    }

}

export default App;
