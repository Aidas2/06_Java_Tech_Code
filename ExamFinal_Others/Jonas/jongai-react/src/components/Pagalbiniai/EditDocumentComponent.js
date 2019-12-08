import React from "react";
import FileTransferPopup from "./FileTransferPopup";
import "./FileTransferStyles.css";
// Import React FilePond
import { FilePond, registerPlugin } from "react-filepond";

// Import FilePond styles
import "filepond/dist/filepond.min.css";
import FilePondPluginFileValidateType from "filepond-plugin-file-validate-type";

// Import the Image EXIF Orientation and Image Preview plugins
// Note: These need to be installed separately
// `npm i filepond-plugin-image-preview filepond-plugin-image-exif-orientation --save`
import FilePondPluginImageExifOrientation from "filepond-plugin-image-exif-orientation";
import FilePondPluginImagePreview from "filepond-plugin-image-preview";
import "filepond-plugin-image-preview/dist/filepond-plugin-image-preview.css";

// Register the plugins
registerPlugin(
  FilePondPluginImageExifOrientation,
  FilePondPluginImagePreview,
  FilePondPluginFileValidateType
);

const EditDocumentComponent = props => {
  let optionList = props.typeList.map(v => (
    //<option value = {v}>{v}</option>
    <option key={v}>{v}</option>
  ));
  let AdditionalFiles =
    props.paths &&
    props.paths.map((path, i) => {
      return (
        path && (
          <p key={i}>
            <i
              className="fas fa-times-circle fa-2x"
              title="Pašalinti failą"
              id={path}
              name="additionalFilePathsToDelete"
              onClick={event => props.deleteAdditionalFileHandler(event)}
            />{" "}
            &nbsp; <span className="customFileSpan">{path}</span> &nbsp;{" "}
            <i
              className="mygtukas fas fa-arrow-circle-down fa-2x"
              id={path}
              title="Atsisiųsti pridėtą failą"
              onClick={event => props.fileDownloadHandler(event)}
            />
          </p>
        )
      );
    });

  return (
    <div className="page-holder w-100 d-flex flex-wrap">
      <div className="container-fluid px-xl-5">
        <section className="py-5">
          <div className="col-lg-12 mb-5">
            <div className="card">
              <div className="card-header">
                <h3 className="h6 text-uppercase mb-0">
                  Dokumento redagavimas
                </h3>
              </div>
              <div className="card-body">
                <form className="form-horizontal" onSubmit={props.handleSubmit}>
                  <div className="form-group row">
                    <label className="col-md-2 form-control-label">
                      Dokumento pavadinimas:
                    </label>
                    <div className="col-md-4">
                      <input
                        type="text"
                        className="form-control form-control-success"
                        id="validationDefault01"
                        placeholder="Įveskite pavadinimą"
                        //pattern={props.namePattern}
                        value={props.title}
                        pattern="^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$"
                        required
                        onChange={props.handleChangeOfTitle}
                        //title={props.namePatternTitle}
                      />
                    </div>
                  </div>
                  <div className="form-group row">
                    <label className="col-md-2 form-control-label">
                      Dokumento aprašymas:
                    </label>
                    <div className="col-md-4">
                      <textarea
                        rows="4"
                        cols="50"
                        type="text"
                        className="form-control form-control-success"
                        //name="lastname"
                        placeholder="Įveskite aprašymą"
                        //pattern={props.namePattern}
                        //title={props.namePatternTitle}
                        value={props.description}
                        onChange={props.handleChangeOfDescription}
                      />
                    </div>
                  </div>
                  <div className="form-group row">
                    <label className="col-md-2 form-control-label">
                      Dokumento tipas:
                    </label>
                    <div className="col-md-3">
                      <select
                        className="form-control form-control-success"
                        value={props.type}
                        required
                        onChange={props.handleChangeOfType}
                      >
                        <option hidden>Pasirinkite...</option>
                        {optionList}
                      </select>
                    </div>
                  </div>
                  {/* {!props.path && } */}
                  {props.path ? (
                    <div className="form-group row">
                      <label className="col-md-2 form-control-label">
                        Pridėtas failas:
                      </label>
                      <div className="col-md-4">
                        <p>
                          <i
                            className="fas fa-times-circle fa-2x"
                            id={props.path}
                            name="mainFilePathToDelete"
                            title="Pašalinti failą"
                            onClick={event =>
                              props.deleteMainFileHandler(event)
                            }
                          />
                          &nbsp;{" "}
                          <span className="customFileSpan">{props.path}</span>{" "}
                          &nbsp;{" "}
                          <i
                            className="mygtukas fas fa-arrow-circle-down fa-2x"
                            title="Atsisiųsti pridėtą failą"
                            id={props.path}
                            onClick={event => props.fileDownloadHandler(event)}
                          />
                        </p>
                      </div>
                    </div>
                  ) : (
                    <div className="form-group row">
                      <label className="col-md-2 col-lg-2 form-control-label">
                        Pasirinkite pridedamus failus:
                      </label>
                      <div className="col-md-6 col-lg-4">
                        {" "}
                        <FilePond
                          labelIdle='<span class="filepond--label-action"> Įkelkite</span> pagrindinę bylą.'
                          // labelIdle="Įkelkite pagrindinę bylą."
                          labelFileTypeNotAllowed=""
                          fileValidateTypeLabelExpectedTypes=""
                          labelButtonRemoveItem="Pašalinti"
                          name="selectedFiles"
                          allowMultiple={false}
                          // onaddfile={props.validate}
                          onupdatefiles={fileItem =>
                            props.onUpdateMainFile(fileItem)
                          }
                          acceptedFileTypes={["application/pdf"]}
                        />
                      </div>
                      <div className="col-md-3">
                        <FileTransferPopup
                          show={props.isOpen}
                          onClose={props.closeFileTransferPopup}
                          percentage={props.percentage}
                        />
                      </div>
                    </div>
                  )}
                  <div className="form-group row">
                    <label className="col-md-2 form-control-label ">
                      {props.paths && props.paths.length === 0
                        ? ""
                        : "Pridėti papildomi failai:"}
                    </label>
                    <div className="col-md-4">{AdditionalFiles}</div>
                  </div>
                  <div className="row">
                    <label className="col-md-2 form-control-label ">
                      Pasirinkite pridedamus failus:
                    </label>
                    <div className="col-md-6 col-lg-4">
                      <FilePond
                        labelIdle='<span class="filepond--label-action"> Įkelkite</span> papildomas bylas.'
                        labelFileTypeNotAllowed=""
                        fileValidateTypeLabelExpectedTypes=""
                        labelButtonRemoveItem="Pašalinti"
                        name="selectedAdditionalFiles"
                        allowMultiple={true}
                        onupdatefiles={fileItems =>
                          props.onUpdateAdditionalFiles(fileItems)
                        }
                        acceptedFileTypes={[
                          "application/pdf",
                          "image/png",
                          "image/jpg"
                        ]}
                      />
                    </div>
                  </div>

                  <div className="form-group row">
                    <div className="col-md-9">
                      <button className="btn submitButton" type="submit">
                        Išsaugoti
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>

    // <form onSubmit={props.handleSubmit}>
    //     <div className="form-row">
    //         <div className="col-md-12 mb-12">
    //             <h5>Esamo dokumento redagavimas</h5>
    //         </div>
    //     </div>
    //     <div className="form-row">
    //         <div className="col-md-4 mb-3">
    //             <label htmlFor="validationDefault01">Dokumento pavadinimas:</label>
    //             <input type="text" className="form-control" id="validationDefault01" placeholder="Įveskite pavadinimą" value={props.title} required onChange={props.handleChangeOfTitle}></input>
    //         </div>
    //     </div>
    //     <div className="form-row">
    //         <div className="col-md-4 mb-3">
    //             <label htmlFor="validationDefault02">Dokumento aprašymas:</label>
    //             <input type="text" className="form-control" id="validationDefault02" placeholder="Įveskite aprašymą" value={props.description} required onChange={props.handleChangeOfDescription}></input>
    //         </div>
    //     </div>

    //     <div className="form-row">
    //         <div className="col-md-4 mb-3">
    //             <label htmlFor="validationDefault03">Dokumento tipas</label>
    //             <select className="form-control" value={props.type} required onChange={props.handleChangeOfType}>
    //                 <option hidden>Pasirinkite...</option>
    //                 {optionList}
    //             </select>
    //         </div>
    //     </div>
    //     <div className="form-row">
    //         <div className="col-md-4 mb-3">
    //             <p>Pridėtas failas:</p>
    //             <p>{props.path} &nbsp; <button className="btn btn-primary" type="button" onClick={() => props.downloadHandler()}>Atsisiųsti</button></p>
    //         </div>
    //     </div>
    //     <div className="form-row">
    //         <div className="col-md-4 mb-3">
    //             <label htmlFor="Upload file">Pasirinkite naują pridedamą failą</label>
    //             <div className="input-group mb-1">
    //                 <input
    //                     onChange={props.onFileSelectHandler}
    //                     id="Upload file"
    //                     name="selectedFiles"
    //                     className="input-file"
    //                     type="file"
    //                     accept=".pdf, .jpg, .png"
    //                 />
    //             </div>
    //         </div>
    //     </div>
    //     <button className="btn btn-primary" type="submit">Išsaugoti</button> &nbsp;
    //     <button className="btn btn-danger" type="button" onClick={props.handleDelete}>Ištrinti</button> &nbsp;
    //     <a href="/createdDocuments" className="btn btn-dark" role="button" aria-pressed="true">Atmesti pakeitimus</a>
    // </form>
  );
};

export default EditDocumentComponent;
