import React from "react";
import EditDocumentComponent from "./EditDocumentComponent";
import axios from "axios";

class EditDocumentContainer extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      id: "default kodas",
      title: "default title",
      description: "",
      username: "migle",
      documentTypeTitle: "Antras tipas",
      typeList: [],
      selectedFiles: null,
      paths: null,
      path: "",
      prefix: "",
      isOpen: false,
      isHidden: false,
      percentage: 0,
      mainFile: null,
      selectedAdditionalFiles: null,
      additionalFilePathsToDelete: [],
      mainFilePathToDelete: null
    };
  }
  acceptedFileTypes = ["pdf", "jpg", "png"];
  toggleHidden() {
    this.setState({
      isHidden: !this.state.isHidden
    });
  }
  handleChangeOfTitle = event => {
    this.setState({ title: event.target.value });
  };

  handleChangeOfDescription = event => {
    this.setState({ description: event.target.value });
  };

  handleChangeOfType = event => {
    this.setState({ documentTypeTitle: event.target.value });
  };

  onFileSelectHandler = event => {
    console.log(event.target.files);
    this.setState({ [event.target.name]: event.target.files });
  };

  openFileTransferPopup = () => {
    this.setState({ isOpen: true });
  };

  closeFileTransferPopup = () => {
    this.setState({ isOpen: false });
  };

  downloadHandler = event => {
    axios({
      url: "http://localhost:8081/api/docs/" + this.state.id + "/download", //doc id
      method: "GET",
      responseType: "blob" // important
    }).then(response => {
      var filename = this.extractFileName(
        response.headers["content-disposition"]
      );
      const url = window.URL.createObjectURL(new Blob([response.data]));
      const link = document.createElement("a");
      link.href = url;
      link.setAttribute("download", filename); //or any other extension
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);
    });
  };
  fileDownloadHandler = event => {
    console.log(event.target);
    axios({
      url:
        "http://localhost:8081/api/docs/" +
        this.state.id +
        "/" +
        event.target.id +
        "/download", //doc id
      method: "GET",
      responseType: "blob" // important
    }).then(response => {
      var filename = this.extractFileName(
        response.headers["content-disposition"]
      );
      const url = window.URL.createObjectURL(new Blob([response.data]));
      const link = document.createElement("a");
      link.href = url;
      link.setAttribute("download", filename); //or any other extension
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);
    });
  };
  extractFileName = contentDispositionValue => {
    var filename = "";
    if (
      contentDispositionValue &&
      contentDispositionValue.indexOf("attachment") !== -1
    ) {
      var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
      var matches = filenameRegex.exec(contentDispositionValue);
      if (matches != null && matches[1]) {
        filename = matches[1].replace(/['"]/g, "");
      }
    }
    return filename;
  };
  /************************************************************************************* */
  updateDocumentInfo = (file, model) => {
    file.append("", "blob", "");
    file.append("model", JSON.stringify(model));
    axios
      .put("http://localhost:8081/api/docs/" + this.state.id, file, {
        onUploadProgress: progressEvent => {
          this.setState({
            percentage: Math.round(
              (progressEvent.loaded / progressEvent.total) * 100
            )
          });
          console.log(
            "Upload progress: " +
              (progressEvent.loaded / progressEvent.total) * 100 +
              "%"
          );
        }
      })
      .then(response => this.props.history.push(`/createdDocuments`))
      .catch(err => console.log("KLAIDA SUBMITE" + err));
  };
  uploadMainFile = (file, model) => {
    file.append("file", this.state.mainFile[0], this.state.mainFile[0].name);
    file.append("model", JSON.stringify(model));
    axios
      .put("http://localhost:8081/api/docs/" + this.state.id, file, {
        onUploadProgress: progressEvent => {
          this.setState({
            percentage: Math.round(
              (progressEvent.loaded / progressEvent.total) * 100
            )
          });
          console.log(
            "Upload progress: " +
              (progressEvent.loaded / progressEvent.total) * 100 +
              "%"
          );
        }
      })
      .then(response => this.props.history.push(`/createdDocuments`))
      .catch(err => console.log("KLAIDA SUBMITE" + err));
  };

  uploadMultipleFiles = (file, model) => {
    file.append("file", this.state.mainFile[0], this.state.mainFile[0].name);
    for (let i = 0; i < this.state.selectedAdditionalFiles.length; i++) {
      file.append(
        "file",
        this.state.selectedAdditionalFiles[i],
        this.state.selectedAdditionalFiles[i].name
      );
      file.append("model", JSON.stringify(model));
    }
    axios
      .put("http://localhost:8081/api/docs/" + this.state.id, file, {
        onUploadProgress: progressEvent => {
          console.log(
            "Upload progress: " +
              (progressEvent.loaded / progressEvent.total) * 100 +
              "%"
          );
        }
      })
      .then(() => this.props.history.push(`/createdDocuments`))
      .catch(err => console.log(err));
  };
  uploadAdditionalFiles = (file, model) => {
    file.append("model", JSON.stringify(model));
    for (let i = 0; i < this.state.selectedAdditionalFiles.length; i++) {
      file.append(
        "file",
        this.state.selectedAdditionalFiles[i],
        this.state.selectedAdditionalFiles[i].name
      );
    }
    axios
      .put("http://localhost:8081/api/docs/" + this.state.id, file, {
        onUploadProgress: progressEvent => {
          this.setState({
            percentage: Math.round(
              (progressEvent.loaded / progressEvent.total) * 100
            )
          });
          console.log(
            "Upload progress: " +
              (progressEvent.loaded / progressEvent.total) * 100 +
              "%"
          );
        }
      })
      .then(response => this.props.history.push(`/createdDocuments`))
      .catch(err => console.log("KLAIDA SUBMITE" + err));
  };

  checkDuplicates = array => {
    return new Set(array).size !== array.length;
  };
  checkFileExtensions = (array, acceptedTypesArray) => {
    let stopSubmit = false;
    console.log(acceptedTypesArray);
    array.forEach(element => {
      if (!acceptedTypesArray.includes(element.split(".").pop())) {
        stopSubmit = true;
      }
    });
    return stopSubmit;
  };
  gatherAllFileNames = () => {
    let fileNames = [];
    if (this.state.mainFile !== null && this.state.mainFile.length !== 0) {
      fileNames.push(this.state.mainFile[0].name);
    }
    if (this.state.path !== null) {
      fileNames.push(this.state.path);
    }
    if (this.state.paths !== null)
      this.state.paths.forEach(additionalFilePath => {
        fileNames.push(additionalFilePath);
      });
    if (this.state.selectedAdditionalFiles !== null) {
      this.state.selectedAdditionalFiles.forEach(additionalFilePath => {
        fileNames.push(additionalFilePath.name);
      });
    }
    return fileNames;
  };
  /************************************************************************************* */
  handleSubmit = event => {
    event.preventDefault();

    let model = {
      description: this.state.description,
      documentTypeTitle: this.state.documentTypeTitle,
      title: this.state.title,
      mainFilePathToDelete: this.state.mainFilePathToDelete,
      additionalFilePathsToDelete: this.state.additionalFilePathsToDelete
    };
    let file = new FormData();

    let fileNames = this.gatherAllFileNames();
    console.log(this.checkFileExtensions(fileNames, this.acceptedFileTypes));
    if (
      this.state.path === null &&
      (this.state.mainFile === null || this.state.mainFile.length === 0)
    ) {
      this.props.showResponseMessage(
        "Įkelkite pagrindinę bylą.",
        "danger",
        2500
      );
    } else if (this.checkDuplicates(fileNames)) {
      this.props.showResponseMessage(
        "Bylų pavadinimai vienodi. Pasirinkite kitas bylas arba jas pervadinkite.",
        "danger",
        2500
      );
    } else if (this.checkFileExtensions(fileNames, this.acceptedFileTypes)) {
      this.props.showResponseMessage(
        "Prisegta byla nėra teisingo formato.",
        "danger",
        2500
      );
    } else if (
      // Update only additonalFile
      this.state.selectedAdditionalFiles !== null &&
      this.state.mainFile === null
    ) {
      this.uploadAdditionalFiles(file, model);
    } else if (
      // Update only mainFile
      this.state.mainFile !== null &&
      (this.state.selectedAdditionalFiles === null ||
        this.state.selectedAdditionalFiles.length === 0)
    ) {
      if (this.checkFileExtensions([this.state.mainFile[0].name], ["pdf"])) {
        this.props.showResponseMessage(
          "Prisegta byla nėra teisingo formato.",
          "danger",
          2500
        );
      } else {
        this.uploadMainFile(file, model);
      }
    } else if (
      // Update both additionalFiles and mainFile
      this.state.selectedAdditionalFiles !== null &&
      this.state.mainFile !== null
    ) {
      this.uploadMultipleFiles(file, model);
    } else {
      this.updateDocumentInfo(file, model);
    }
  };

  onUpdateMainFile = fileItems => {
    this.setState({
      mainFile: fileItems.map(fileItem => fileItem.file)
    });
  };
  onUpdateAdditionalFiles = fileItems => {
    this.setState({
      selectedAdditionalFiles: fileItems.map(fileItem => fileItem.file)
    });
  };
  deleteMainFileHandler = event => {
    event.preventDefault();
    this.setState({
      mainFilePathToDelete:
        event.target.id === this.state.path ? this.state.path : null,
      path: event.target.id === this.state.path ? null : this.state.path
    });
  };
  deleteAdditionalFileHandler = event => {
    event.preventDefault();
    this.setState({
      additionalFilePathsToDelete: this.state.additionalFilePathsToDelete.concat(
        this.state.paths.filter(p => p === event.target.id)
      ),
      paths: this.state.paths.filter(p => p !== event.target.id)
    });
  };

  componentDidMount() {
    //nusiskaitau dokumentų tipus

    //let currentUser = JSON.parse(localStorage.getItem("user"));
    //console.log("Spausdinu userį gautą iš localStorage");
    //console.log(currentUser);
    //this.setState({ username: currentUser.username }, () => {
    //nusiskaitau dokumentų tipus
    axios
      .get("http://localhost:8081/api/users/submissionDocTypes")
      .then(response => {
        this.setState({ typeList: response.data.map(item => item.title) });
        console.log(
          "Koks atiduodamas dokumentų tipų sąrašas (naujame dokumente)?"
        );
        console.log(this.state.typeList);
      })
      .catch(error => {
        console.log("KLAIDA!!!!" + error);
      });

    //Konkretaus dokumento duomenų nuskaitymas
    const position = this.props.match.params.documentId;
    //let currentUser = "migle";
    let resourcePath = "http://localhost:8081/api/docs/" + position;

    axios
      .get(resourcePath)
      .then(response => {
        //this.setState(response.data);
        // console.log(response.data.id);
        //console.log(response.data.title);

        //TODO
        //Čia to lyg ir nereikia, nes dabar PATH tik failo pavadinimą ir turi
        // var realFileName = "";
        // if (response.data.path.lastIndexOf(response.data.prefix) !== -1) {
        //   realFileName = response.data.path.substring(0, response.data.path.lastIndexOf(response.data.prefix));
        // }
        this.setState({ id: response.data.id });
        this.setState({ title: response.data.title });
        this.setState({ description: response.data.description });
        this.setState({ documentTypeTitle: response.data.documentTypeTitle });
        this.setState({ path: response.data.path });
        this.setState({ paths: response.data.additionalFilePaths });
        this.setState({ prefix: response.data.prefix });
        //this.setState({ filename: realFileName });
        console.log("Gavau tokį produktą į redagavimą");
        console.log(this.state);
        let currentUser = JSON.parse(localStorage.getItem("user"));
        console.log("Spausdinu userį gautą iš localStorage");
        console.log(currentUser);
        this.setState({ username: currentUser.username });

        //console.log("Pagaminau tokį State ->" + this.state);
        //console.log("Toks description iš state'o -> " + this.state.id);
      })
      .catch(error => {
        console.log(error);
      });
  }

  render() {
    return (
      <EditDocumentComponent
        title={this.state.title}
        description={this.state.description}
        typeList={this.state.typeList}
        type={this.state.documentTypeTitle}
        path={this.state.path}
        paths={this.state.paths}
        prefix={this.state.prefix}
        //filename = { this.state.filename }
        handleChangeOfTitle={this.handleChangeOfTitle}
        handleChangeOfDescription={this.handleChangeOfDescription}
        handleChangeOfType={this.handleChangeOfType}
        handleSubmit={this.handleSubmit}
        handleDelete={this.handleDelete}
        downloadHandler={this.downloadHandler}
        fileDownloadHandler={this.fileDownloadHandler}
        onFileSelectHandler={this.onFileSelectHandler}
        isOpen={this.state.isOpen}
        percentage={this.state.percentage}
        openFileTransferPopup={this.openFileTransferPopup}
        closeFileTransferPopup={this.closeFileTransferPopup}
        deleteMainFileHandler={this.deleteMainFileHandler}
        deleteAdditionalFileHandler={this.deleteAdditionalFileHandler}
        onUpdateAdditionalFiles={this.onUpdateAdditionalFiles}
        onUpdateMainFile={this.onUpdateMainFile}
      />
    );
  }
}

export default EditDocumentContainer;
