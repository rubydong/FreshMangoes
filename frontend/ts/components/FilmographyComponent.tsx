import * as React from "react";

export class FilmographyComponent extends React.Component {
    render() {
        const filmsObject = this.props['data-roles'];
        const films = Object.keys(this.props['data-roles']);

        const filmography = films.map((film) => {
            let title = film;
            let role = Object.keys(filmsObject[title])[0];
            let content = filmsObject[title];
            let id = content[role].id;
            let type = content[role].type.toLowerCase();
            let score = content[role].metadata.mangoScore;

            return <tr>
                <td>
                    <a href={'../' + type + '/' + id}>{title}</a>
                </td>
                <td>{score}%</td>
                <td>{type}</td>
                <td>{role}</td>
            </tr>
        });

        return (
            <div className="filmography margin-top-bottom">
                <h2> Filmography </h2>
                <hr/>
                <table className="table">
                    <thead className="thead-light">
                        <tr>
                            <th>Title</th>
                            <th>Rating</th>
                            <th>Type</th>
                            <th>Role</th>
                        </tr>
                    </thead>
                    <tbody>{filmography}</tbody>
                </table>
            </div>
        );
    }
}