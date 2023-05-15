// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module rooch_test_proj1::product_created {

    use moveos_std::object::ObjectID;
    use rooch_test_proj1::product::{Self, ProductCreated};
    use std::option;
    use std::string::String;

    public fun id(product_created: &ProductCreated): option::Option<ObjectID> {
        product::product_created_id(product_created)
    }

    public fun product_id(product_created: &ProductCreated): String {
        product::product_created_product_id(product_created)
    }

    public fun name(product_created: &ProductCreated): String {
        product::product_created_name(product_created)
    }

    public fun unit_price(product_created: &ProductCreated): u128 {
        product::product_created_unit_price(product_created)
    }

}
