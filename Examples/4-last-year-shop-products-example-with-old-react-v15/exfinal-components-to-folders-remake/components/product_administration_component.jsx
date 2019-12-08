var PropTypes = React.PropTypes;

var ProductAdministrationComponent = function(props) {
  var title;
  var saveButton;
  if (props.id) {
    title = 'Atnaujinamas produktas ' + props.id;
  } else {
    title = 'Kuriamas naujas produktas';
    saveButton = <button className="btn btn-success" style={{ marginRight: '20px' }} onClick={props.onSaveClick}>Save</button>
  }
  return (
    <div>
      <h2>{title}</h2>
      <form>
        <div className="form-group">
          <label>Title</label>
          <input className="form-control" value={props.title} onChange={props.onTitleChange} />
        </div>
        <div className="form-group">
          <label>Image url</label>
          <input className="form-control" value={props.image} onChange={props.onImageChange} />
        </div>
        <div className="form-group">
          <label>Description</label>
          <input
            className="form-control"
            value={props.description}
            onChange={props.onDescriptionChange}
          />
        </div>
        <div className="form-group">
          <label>Price</label>
          <input className="form-control" value={props.price} onChange={props.onPriceChange} />
        </div>
        <div className="form-group">
          <label>Quantity</label>
          <input
            className="form-control"
            value={props.quantity}
            onChange={props.onQuantityChange}
          />
        </div>

        {saveButton}
      </form>
    </div>
  );
};

ProductAdministrationComponent.propTypes = {
  id: React.PropTypes.any,
  image: React.PropTypes.string.isRequired,
  title: React.PropTypes.string.isRequired,
  description: React.PropTypes.string.isRequired,
  price: React.PropTypes.any.isRequired,
  quantity: React.PropTypes.any.isRequired,

  onImageChange: React.PropTypes.func.isRequired,
  onTitleChange: React.PropTypes.func.isRequired,
  onDescriptionChange: React.PropTypes.func.isRequired,
  onPriceChange: React.PropTypes.func.isRequired,
  onQuantityChange: React.PropTypes.func.isRequired,
  onSaveClick: React.PropTypes.func.isRequired,
};

window.ProductAdministrationComponent = ProductAdministrationComponent;
