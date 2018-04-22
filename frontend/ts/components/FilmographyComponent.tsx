import * as React from "react";

export class FilmographyComponent extends React.Component {
    render() {
        const films = this.props['data-roles'];
    
        const filmography = films.map((film) => {
            
            return <tr>
                <td>
                    <a href={'../' + film.content.type.toLowerCase() + '/' + film.content.id}> {film.content.metadata.name} </a>
                </td>
                <td>{film.content.metadata.mangoScore}%</td>
                <td>{film.content.type}</td>
                <td>{film.role}</td>
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