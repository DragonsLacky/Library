import React from 'react';
import {useHistory} from 'react-router-dom';

const ProductAdd = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name: "",
        category: props.categories[0].toUpperCase(),
        author: props.authors[0].id,
        availableCopies: 0
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const author = formData.author;
        const category = formData.category;
        const availableCopies = formData.availableCopies;

        props.onAddBook(name, category, author, availableCopies);
        history.push("/books");
    }

    return(
        <div className={"row mt-5"}>
            <div className={"col-md-6 offset-md-3"}>
                <form onSubmit={onFormSubmit}>
                    <div className={"form-group"}>
                        <label htmlFor={"name"}>Book name</label>
                        <input type={"text"}
                               className={"form-control"}
                               id={"name"}
                               name={"name"}
                               required
                               placeholder={"Enter Book name"}
                               onChange={handleChange}
                        />
                    </div>
                    <div className={"form-group"}>
                        <label>Category</label>
                        <select name={"category"} className={"form-control"} onChange={handleChange}>
                            {props.categories.map((category) =>
                                <option value={category.toUpperCase()}>{category}</option>
                            )}
                        </select>
                    </div>
                    <div className={"form-group"}>
                        <label>Author</label>
                        <select name={"manufacturer"} className={"form-control"} onChange={handleChange}>
                            {props.authors.map((author) =>
                                <option value={author.id}>{author.name + ' ' + author.surname}</option>
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="name">Available  copies</label>
                        <input type={"number"}
                               min={0}
                               className={"form-control"}
                               id={"availableCopies"}
                               name={"availableCopies"}
                               required
                               placeholder={"Enter number of available copies"}
                               onChange={handleChange}
                        />
                    </div>
                    <button id={"submit"} type={"submit"} className={"btn btn-primary"}>Submit</button>
                </form>
            </div>
        </div>
    )
}

export default ProductAdd;
