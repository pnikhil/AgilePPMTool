import React, {Component} from 'react';
import {faFlag, faEdit, faTrash} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {Link} from "react-router-dom";
import PropTypes from "prop-types";
import {connect} from "react-redux";
import {deleteProject} from "../../actions/projectAction";


class ProjectItem extends Component {
    onDeleteClick = id => {
        this.props.deleteProject(id);
    };

    render() {
        const {project} = this.props;
        return (
            <div className="container">
                <div className="card card-body bg-light mb-3">
                    <div className="row">
                        <div className="col-2">
                            <span className="mx-auto"> {project.projectIdentifier}</span>
                        </div>
                        <div className="col-lg-6 col-md-4 col-8">
                            <h3>{project.projectName}</h3>
                            <p>{project.description}</p>
                        </div>
                        <div className="col-md-4 d-none d-lg-block">
                            <ul className="list-group">
                                <a href="#">
                                    <li className="list-group-item board">
                                        <FontAwesomeIcon icon={faFlag}/> Project Board
                                    </li>
                                </a>
                                <Link to={`/updateProject/${project.projectIdentifier}`}>
                                    <li className="list-group-item update">
                                        <i className="pr-1 fa fa-edit"> <FontAwesomeIcon icon={faEdit}/> Update Project
                                            Info</i>
                                    </li>
                                </Link>

                                <li className="list-group-item delete"
                                    onClick={this.onDeleteClick.bind(this, project.projectIdentifier)}>
                                    <i className="pr-1 fa fa-minus-circle"> <FontAwesomeIcon icon={faTrash}/> Delete
                                        Project</i>
                                </li>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

ProjectItem.propTypes = {
    deleteProject: PropTypes.func.isRequired
};

export default connect(
    null,
    { deleteProject }
)(ProjectItem);
