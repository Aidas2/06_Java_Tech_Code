/*
//39 psl.
const component = <h1>Hello, world</h1>;    //sukuriam kintamaji
ReactDOM.render(
    component,                              //tai ka paduodam i renderi (kintamaji)
    document.getElementById('root')         //tai ka gaunam is renderio (prideda kintamaji prie #root)
);
*/
//=================================================
/*
//40 psl. Neveikia, meta klaida "TypeError: React.createClass is not a function"
var HelloComponent = React.createClass({
    render: function () {
        return React.createElement(
            "div",
            null,
            "Hello ",
            this.props.name
        );
    }
});
ReactDOM.render(React.createElement(
    HelloComponent,
    { name: "Jane" }),
    document.getElementById('root')
);
*/
//=================================================
/*
//41 psl. Nereikejo kopijuoti ?
<MyButton color="blue" shadowSize={2}>
    Click Me
</MyButton>

var butt = React.createElement(
    MyButton,
    { color: 'blue', shadowSize: 2 },
    'Click Me'
)
*/
//=================================================
/*
// 44 psl. senovinis variantas
var HelloComponent = React.createClass({
    render: function () {
        return <div>Hello {this.props.name}</div>;
    }
});
ReactDOM.render(React.createElement(
    HelloComponent,
    { name: "Jane" }),
    document.getElementById('root')
);
*/
//=================================================
/*
//45 psl. komponento MyButton sukurimas-aprasymas
class MyButton extends React.Component {
    render() {
        return <button>Mygtukas</button>; // nurodymas ka atvaizduoti
    }
}

//komponento HelloComponent sukurimas-aprasymas
class HelloComponent extends React.Component {
    render() {
        return <div>Hello {this.props.name} <MyButton /></div>; // nurodymas ka atvaizduoti 
    }                                                          //iskarto idedam ir antra komponenta
}

// nurodau kad komponenta ideti i #root. 
ReactDOM.render(
    <HelloComponent name="Jane" />, //paduodam renderiui sita
    //<MyButton/>,                        // arba sita (abieju iskart negalima)
    document.getElementById('root') // nurodymas kur ideti (prie #root)
);
*/
//================= 48 psl. KOMPONENTŲ KOMPOZICIJA #1 ================================
/*
var AvatarComponent = React.createClass({
    render: function () {
        return (
            <img className="Avatar"
                src={this.props.user.avatarUrl}
                alt={this.props.user.name}
            />
        )
    }
});
//================= 49 psl. KOMPONENTŲ KOMPOZICIJA #2 ================================
var CommentComponent = React.createClass({
    render: function () {
        return (
            <div className="Comment">
                <div className="UserInfo">
                    <AvatarComponent user={this.props.author} />
                    <div className="UserInfo-name">
                        {this.props.author.name}
                    </div>
                </div>
            </div>
        );
    }
});
//================= 50 psl. KOMPONENTO ATRIBUTAI (PROPS) #1 ================================
ProductCardComponent.propTypes = {
    id: React.PropTypes.number.isRequired,
    image: React.PropTypes.string.isRequired,
    title: React.PropTypes.string.isRequired,
    description: React.PropTypes.string.isRequired,
    price: React.PropTypes.number.isRequired,
};
//================= 51 psl. KOMPONENTO ATRIBUTAI (PROPS) #2 ================================
<ProductCardComponent
    key={index}
    id={product.id}
    image={product.image}
    title={product.title}
    description={product.description}
    price={product.price}
/>
//================= 52 psl. KOMPONENTAS SU ATRIBUTU ================================
class HelloComponent extends React.Component {
    render() {
        return (<div>Hello {this.props.name}</div>);
    }
}
HelloComponent.propTypes = {
    name: PropTypes.string.isRequired
}
ReactDOM.render(
    (<HelloComponent name="Jane" />),
    document.getElementById('root')
);
*/

//================= 55 psl. STILIAI - PAVYZDYS ================================
var styles = {
    container: { background: 'red' },
    greetingText: { color: 'green' }
};
var Component = React.createClass({
    render: function () {
        return (
            <div style={styles.container}>
                <p style={styles.greetingText}>Tekstas yra tokas</p>
            </div>
        );
    }
});
//================= 56 psl. NAUJO KOMPONENTO ŠABLONAS ================================
class Component extends React.Component {
    render() {
        return (
            <div>
                <!-- Component view -->
    </div>
        );
    }
};
Component.propTypes = {
    // Properties JSON
};
//================= 57 psl. ŠAKNINIO KOMPONENTO NUPIEŠIMAS ================================
ReactDOM.render(
    <Component prop1={prop1Value} />,
    document.getElementById('root')
);
//================= 61 psl. UŽDUOTIS 6 ================================
import './App.css'; // iš src/ katalogo
import pav from './../public/favicon.ico';
var style = {
    backgroundImage: 'url(' + pav + ')', width: 100, height
var styleAlt = {
        backgroundImage: `url(${pav})`, width: 100, height:
var jsx = (<img src={favicon} className="klase-is-app-css" />);
// arba tiesiog į CSS įdedam background-image: url(./logo.png);



