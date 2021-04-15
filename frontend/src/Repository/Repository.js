import axios from '../Config/AxiosConfig';

const BookRepository = {
    fetchBooks: () => {
        return axios.get('/books');
    },
    getBook: (id) => {
      return axios.get(`/books/${id}`)
    },
    addBook:  (name, category, author, availableCopies) => {
        return axios.post('/books/add', {
            'name' : name,
            'category': category,
            'author': author,
            'availableCopies' : availableCopies
        });
    },
    editBook: (id, name, category, author, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            'name' : name,
            'category': category,
            'author': author,
            'availableCopies' : availableCopies
        });
    },
    markBook: (id) => {
        return axios.put(`/books/mark/${id}`);
    },
    deleteBook: (id) => {
      return axios.delete(`/books/delete/${id}`);
    }
}

const CategoryRepository = {
    fetchCategories: () => {
        return axios.get('/categories');
    }
}

const AuthorRepository = {
    fetchAuthors: () => {
        return axios.get('/authors');
    }
}

export {
    BookRepository,
    CategoryRepository,
    AuthorRepository
} ;