import React, {Component} from 'react';
import PropTypes from "prop-types"
import {connect} from "react-redux"
import {createProject} from "../../actions/projectAction";
import classnames from "classnames"

class AddProject extends Component {

    constructor(props) {
        super(props);

        this.state = {
            projectName: "",
            projectIdentifier: "",
            description: "",
            startDate: "",
            endDate: "",
            errors: {}
        }

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    //life-cycle hooks
    componentDidUpdate(prevProps) {
        if (this.props.errors !== prevProps.errors) {
            this.setState({errors: this.props.errors});
        }
    }

    //life cycle hooks
    onChange(e) {
        this.setState({[e.target.name]: e.target.value});
    };

    onSubmit(e) {
        e.preventDefault();
        const newProject = {
            projectName: this.state.projectName,
            projectIdentifier: this.state.projectIdentifier,
            description: this.state.description,
            startDate: this.state.startDate,
            endDate: this.state.endDate
        };
        console.log(newProject);

        this.props.createProject(newProject, this.props.history);
    }

    render() {
        let description = "description";
        let projectName = "projectName";
        let projectIdentifier = "projectIdentifier";

        const {errors} = this.state;


        return (

            <div className="project">
                <div className="container">
                    <div className="row">
                        <div className="col-md-8 m-auto">
                            <h5 className="display-4 text-center">Create Project Form</h5>
                            <hr/>
                            <form onSubmit={this.onSubmit}>
                                <div className="form-group">
                                    <input type="text" className={classnames("form-control form-control-lg", {
                                        "is-invalid": errors.projectName
                                    })} placeholder="Project Name" onChange={this.onChange} name={projectName}
                                           value={this.state.projectName}/>
                                    {errors.projectName && (
                                        <div class="invalid-feedback">{errors.projectName}</div>
                                    )}
                                </div>
                                <div className="form-group">
                                    <input type="text" className={classnames("form-control form-control-lg", {
                                        "is-invalid": errors.projectIdentifier
                                    })}
                                           placeholder="Unique Project ID" onChange={this.onChange}
                                           name={projectIdentifier} value={this.state.projectIdentifier}/>
                                    {errors.projectIdentifier && (
                                        <div class="invalid-feedback">{errors.projectIdentifier}</div>
                                    )}
                                </div>
                                <div className="form-group">
                                    <textarea className={classnames("form-control form-control-lg", {
                                        "is-invalid": errors.description
                                    })}
                                              onChange={this.onChange} placeholder="Project Description"
                                              value={this.state.description} name={description}></textarea>
                                    {errors.description && (
                                        <div class="invalid-feedback">{errors.description}</div>
                                    )}
                                </div>
                                <h6>Start Date</h6>
                                <div className="form-group">
                                    <input type="date" onChange={this.onChange} className="form-control form-control-lg"
                                           value={this.state.startDate} name="startDate"/>
                                </div>
                                <h6>Estimated End Date</h6>
                                <div className="form-group">
                                    <input type="date" onChange={this.onChange} className="form-control form-control-lg"
                                           value={this.state.endDate} name="endDate"/>
                                </div>

                                <input type="submit" className="btn btn-primary btn-block mt-4"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

AddProject.propTypes = {
    createProject: PropTypes.func.isRequired,
    errors: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
    errors: state.errors
})
export default connect(mapStateToProps, {createProject})(AddProject);
