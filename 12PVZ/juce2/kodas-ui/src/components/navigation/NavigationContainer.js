import React from "react";
import { Route, BrowserRouter, Switch } from "react-router-dom";

import StudioContainer from "../Studio/StudioContainer";
import Navigation from "./Navigation";
import StudioDetails from "../Studio/StudioDetails";
import PerformerContainer from "../Performer/PerformerContainer";
import StudioUpdateForm from "../Studio/StudioUpdateForm";

const NavigationContainer = () => {
  return (
    <div>
      <BrowserRouter>
        <div>
          <Navigation />
          <Switch>
            <Route path="/" exact component={StudioContainer} />
            <Route path="/studios/:title" component={StudioDetails} exact />
            <Route path="/performers" component={PerformerContainer} exact />
            <Route
              path="/studios/update/:title"
              component={StudioUpdateForm}
              exact
            />
          </Switch>
        </div>
      </BrowserRouter>
    </div>
  );
};

export default NavigationContainer;
