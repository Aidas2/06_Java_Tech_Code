import React from 'react';
import { Link } from 'react-router-dom';


const ReviewDocumentsComponent = (props) => {
    var linkas = "/reviewDocuments/" + props.id;
    return (
        <tr>
            <td>{props.author}</td>
            <td>{props.id}</td>
            <td>{props.title}</td>
            <td>{props.description}</td>
            <td>{props.type}</td>
            <td>{props.submissionDate}</td>
            <td>
                <Link style={{ textDecoration: 'none', color: 'black', cursor: 'default' }} to={linkas}> <i className="fas fa-info-circle fa-2x" title="Dokumento informacija"></i> </Link> &nbsp;
                <i className="fas fa-check-circle fa-2x" title="Priimti dokumentą" onClick={() => { props.handleAccept(props.id) }}></i> &nbsp;
                <i className="fas fa-times-circle fa-2x" title="Atmesti dokumentą" onClick={() => props.handleReject(props.id)}></i>
            </td>
        </tr>



        // <div className="container-fluid">
        //     <div className="row">
        //         <div className="col-2">
        //             <p>{props.author}</p>
        //         </div>
        //         <div className="col-2">
        //             <p>{props.id}</p>
        //         </div>
        //         <div className="col-2">
        //             <p>{props.title}</p>
        //         </div>
        //         <div className="col-2">
        //             <p>{props.description}</p>
        //         </div>
        //         <div className="col-1">
        //             <p>{props.type}</p>
        //         </div>
        //         <div className="col-1">
        //             <p>{props.submissionDate}</p>
        //         </div>
        //         <div className="col-1">
        //             <Link to={linkas}> <i className="fas fa-info-circle"></i> </Link> &nbsp;
        //             {/* <Link to={linkas}> <i className="fas fa-check-circle"></i> </Link> */}
        //             <i className="fas fa-check-circle" onClick={() => { props.handleAccept(props.id) }}></i> &nbsp;
        //             <i className="fas fa-times-circle" onClick={() => props.handleReject(props.id)}></i>
        //             {/* <Link to={linkas}> <i className="fas fa-times-circle"></i> </Link> */}
        //         </div>
        //     </div>
        // </div>
    );
}

export default ReviewDocumentsComponent;