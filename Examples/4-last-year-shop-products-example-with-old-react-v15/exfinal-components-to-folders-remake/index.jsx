var App = function(props) {
  return <div>{props.children}</div>;
};
var ProductListPage = function () {
  return <ProductListContainer />
}
var NoMatch = function(props) {
  return <div>Route did not match</div>;
};

var SomePageComponent = function(props) {
  var goRoot = function(e) {
    props.router.push("/");
  }
  return (
    <div>
      At route: {props.router.getCurrentLocation().pathname}
      <button onClick={goRoot}>Go to Root route</button>
      <pre>
        {JSON.stringify(props, null, 2)}
      </pre>
    </div>
  );
};

var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var IndexRoute = ReactRouter.IndexRoute;

ReactDOM.render((
  <Router history={ReactRouter.hashHistory}>
    <Route path="/" component={App}>
      <IndexRoute component={ProductListPage} />
      <Route path="/products" component={ProductListPage} />
      <Route path="/admin/products/new" component={ProductAdministrationContainer} />
      <Route path="/admin/products/:id" component={ProductAdministrationContainer} />
      <Route path="*" component={NoMatch}/>
    </Route>
  </Router>
), document.getElementById('root'));
