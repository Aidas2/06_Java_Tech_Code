import React from "react";

import logo from "./home.png";
import infoIcon from "./info-icon.png";
import { Link } from "react-router-dom";

const HolidayDetailsComponent = props => {
  var {
    title,
    description,
    type,
    imageOfHoliday,
    isFlagRaised,
    hireDate,
    distance,
    price
  } = props.holidayDetails;

  // var linkToIndividualHolidayDetails = "/admin/holidays/" + title;
  // const linkToIndividualHolidayUpdateContainer = "/admin/updateHoliday/" + title;

  return (
    <div>
      <div className="container-fluid no-padding">
        <div className="row justify-content-between no-padding ">
          <div className=" col-8  normal-padding">
            {/* <h5 className="display-6  second-navigation-style ">
              <Link to={"/"}>
                <img
                  className="logo-color"
                  src={logo}
                  width="40"
                  height="20"
                  alt=" "
                />
              </Link>
              &ensp;/ &ensp;
              <Link to={"/admin"} className="second-navigation">
                Administratoriaus rolė
              </Link>
              &ensp;/ &ensp;
              <Link to={"/admin/holidays"} className="second-navigation">
                Sventes
              </Link>
              &ensp;/ &ensp;
              <Link
                to={linkToIndividualHolidayDetails}
                className="second-navigation"
              >
                {title}
              </Link>
            </h5> */}
            <h2 className="display-6 ">
              {/* {title} */}
              <div className="logo-info">
                <img
                  src={infoIcon}
                  className="info-icon-style"
                  width="50"
                  height="50"
                  alt="info icon"
                />
                <span className="tooltiptext">
                  Šiame lange yra pateikta šventės "{title}" informacija.
                </span>
              </div>
            </h2>
          </div>
          {/* <div className=" col-4  normal-padding left-align ">
            <Link
              to={linkToIndividualHolidayUpdateContainer}
              className="btn btn-outline-success m-2 button-color "
            >
              Redaguoti sventę
            </Link>
          </div> */}
        </div>

        <div className="container-fluid">
          <div className="row users-padding-bottom table-style-rounded">
            <div className="col-1 users-table-number-style  ">#</div>
            <div className="col-5  users-table-middle-style ">Parametras</div>
            <div className=" col-6 users-table-action-style">Reikšmė</div>
          </div>

          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">1</div>
            <div className="col-5 documents-table-size">Pavadinimas</div>
            <div className="col-6 documents-table-size">{title}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">2</div>
            <div className="col-5 documents-table-size">Aprašymas</div>
            <div className="col-6 documents-table-size">{description}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">3</div>
            <div className="col-5 documents-table-size">Tipas</div>
            <div className="col-6 documents-table-size">{type}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">4</div>
            <div className="col-5 documents-table-size">Nuotrauka</div>
            <div className="col-6 documents-table-size">{imageOfHoliday}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">5</div>
            <div className="col-5 documents-table-size">Ar veliava pakelta ?</div>
            <div className="col-6 documents-table-size">{isFlagRaised}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">6</div>
            <div className="col-5 documents-table-size">Data</div>
            <div className="col-6 documents-table-size">{hireDate}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">7</div>
            <div className="col-5 documents-table-size">Atstumas</div>
            <div className="col-6 documents-table-size">{distance}</div>
          </div>

          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">8</div>
            <div className="col-5 documents-table-size">Kaina, Eur</div>
            <div className="col-6 documents-table-size">{price}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">9</div>
            <div className="col-5 documents-table-size">SUSIETŲ ŠALIŲ SĄRAŠAS:</div>
            <div className="col-6 documents-table-size list-style">
              {props.countries}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default HolidayDetailsComponent;
