// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module rooch_test_proj1::product {
    use moveos_std::account_storage;
    use moveos_std::event;
    use moveos_std::object::{Self, Object};
    use moveos_std::object_id::ObjectID;
    use moveos_std::object_storage;
    use moveos_std::storage_context::{Self, StorageContext};
    use moveos_std::tx_context;
    use std::error;
    use std::option;
    use std::signer;
    use std::string::{Self, String};
    use std::vector;
    friend rooch_test_proj1::product_create_logic;
    friend rooch_test_proj1::product_aggregate;

    const EID_DATA_TOO_LONG: u64 = 102;
    const EINAPPROPRIATE_VERSION: u64 = 103;
    const ENOT_GENESIS_ACCOUNT: u64 = 105;
    const PRODUCT_ID_LENGTH: u64 = 20;


    struct ProductIdGenerator has key {
        sequence: u128,
    }

    struct ProductIdGeneratorCreated has key {
    }

    public fun initialize(storage_ctx: &mut StorageContext, account: &signer) {
        assert!(signer::address_of(account) == @rooch_test_proj1, error::invalid_argument(ENOT_GENESIS_ACCOUNT));
        let product_id_generator = ProductIdGenerator {
            sequence: 0,
        };
        account_storage::global_move_to(
            storage_ctx,
            account,
            product_id_generator
        );
    }

    struct Product has key {
        product_id: String,
        version: u64,
        name: String,
        unit_price: u128,
    }

    /// get object id
    public fun id(product_obj: &Object<Product>): ObjectID {
        object::id(product_obj)
    }

    public fun product_id(product_obj: &Object<Product>): String {
        object::borrow(product_obj).product_id
    }

    public fun version(product_obj: &Object<Product>): u64 {
        object::borrow(product_obj).version
    }

    public fun name(product_obj: &Object<Product>): String {
        object::borrow(product_obj).name
    }

    public(friend) fun set_name(product_obj: &mut Object<Product>, name: String) {
        object::borrow_mut(product_obj).name = name;
    }

    public fun unit_price(product_obj: &Object<Product>): u128 {
        object::borrow(product_obj).unit_price
    }

    public(friend) fun set_unit_price(product_obj: &mut Object<Product>, unit_price: u128) {
        object::borrow_mut(product_obj).unit_price = unit_price;
    }

    fun new_product(
        product_id: String,
        name: String,
        unit_price: u128,
    ): Product {
        assert!(std::string::length(&product_id) <= 20, EID_DATA_TOO_LONG);
        Product {
            product_id,
            version: 0,
            name,
            unit_price,
        }
    }

    struct ProductCreated has key {
        id: option::Option<ObjectID>,
        product_id: String,
        name: String,
        unit_price: u128,
    }

    public fun product_created_id(product_created: &ProductCreated): option::Option<ObjectID> {
        product_created.id
    }

    public(friend) fun set_product_created_id(product_created: &mut ProductCreated, id: ObjectID) {
        product_created.id = option::some(id);
    }

    public fun product_created_product_id(product_created: &ProductCreated): String {
        product_created.product_id
    }

    public fun product_created_name(product_created: &ProductCreated): String {
        product_created.name
    }

    public fun product_created_unit_price(product_created: &ProductCreated): u128 {
        product_created.unit_price
    }

    public(friend) fun new_product_created(
        storage_ctx: &mut StorageContext,
        name: String,
        unit_price: u128,
    ): ProductCreated {
        let product_id_generator =  account_storage::global_borrow_mut<ProductIdGenerator>(storage_ctx, @rooch_test_proj1);
        let product_id = next_product_id(product_id_generator);
        ProductCreated {
            id: option::none(),
            product_id,
            name,
            unit_price,
        }
    }


    public(friend) fun create_product(
        storage_ctx: &mut StorageContext,
        name: String,
        unit_price: u128,
    ): Object<Product> {
        let product_id_generator =  account_storage::global_borrow<ProductIdGenerator>(storage_ctx, @rooch_test_proj1);
        let product_id = current_product_id(product_id_generator);
        let product = new_product(
            product_id,
            name,
            unit_price,
        );
        let tx_ctx = storage_context::tx_context_mut(storage_ctx);
        let obj_owner = tx_context::sender(tx_ctx);
        let product_obj = object::new(
            tx_ctx,
            obj_owner,
            product,
        );
        product_obj
    }

    fun current_product_id(
        product_id_generator: &ProductIdGenerator,
    ): String {
        string::utf8(u128_to_fixed_length_string(product_id_generator.sequence, PRODUCT_ID_LENGTH))
    }

    fun u128_to_fixed_length_string(n: u128, length: u64): vector<u8> {
        let s = vector::empty<u8>();
        let m = n;
        while (m > 0) {
            let digit = ((m % 10) as u8);
            vector::push_back(&mut s, digit + 48);//b'0'
            m = m / 10;
        };
        while (vector::length(&s) < length) {
            vector::push_back(&mut s, 48);//b'0'
        };
        vector::reverse(&mut s);
        s
    }

    fun next_product_id(
        product_id_generator: &mut ProductIdGenerator,
    ): String {
        product_id_generator.sequence = product_id_generator.sequence + 1;
        current_product_id(product_id_generator)
    }

    public(friend) fun update_version_and_add(storage_ctx: &mut StorageContext, product_obj: Object<Product>) {
        object::borrow_mut(&mut product_obj).version = object::borrow( &mut product_obj).version + 1;
        //assert!(object::borrow(&product_obj).version != 0, EINAPPROPRIATE_VERSION);
        private_add_product(storage_ctx, product_obj);
    }

    public(friend) fun remove_product(storage_ctx: &mut StorageContext, obj_id: ObjectID): Object<Product> {
        let obj_store = storage_context::object_storage_mut(storage_ctx);
        object_storage::remove<Product>(obj_store, obj_id)
    }

    public(friend) fun add_product(storage_ctx: &mut StorageContext, product_obj: Object<Product>) {
        assert!(object::borrow(&product_obj).version == 0, EINAPPROPRIATE_VERSION);
        private_add_product(storage_ctx, product_obj);
    }

    fun private_add_product(storage_ctx: &mut StorageContext, product_obj: Object<Product>) {
        assert!(std::string::length(&object::borrow(&product_obj).product_id) <= 20, EID_DATA_TOO_LONG);
        let obj_store = storage_context::object_storage_mut(storage_ctx);
        object_storage::add(obj_store, product_obj);
    }

    public fun get_product(storage_ctx: &mut StorageContext, obj_id: ObjectID): Object<Product> {
        remove_product(storage_ctx, obj_id)
    }

    public fun return_product(storage_ctx: &mut StorageContext, product_obj: Object<Product>) {
        private_add_product(storage_ctx, product_obj);
    }

    public(friend) fun drop_product(product_obj: Object<Product>) {
        let (_id, _owner, product) =  object::unpack(product_obj);
        let Product {
            version: _version,
            product_id: _product_id,
            name: _name,
            unit_price: _unit_price,
        } = product;
    }

    public(friend) fun emit_product_created(storage_ctx: &mut StorageContext, product_created: ProductCreated) {
        event::emit_event(storage_ctx, product_created);
    }

}
